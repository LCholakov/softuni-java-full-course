package org.example.orm;

// How to create:
// alt+enter on dbContext<E> -> implement interface
// alt+enter on the new entityManager -> implement methods

import org.example.orm.annotations.Column;
import org.example.orm.annotations.Entity;
import org.example.orm.annotations.Id;
import org.example.orm.exceptions.ORMException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityManager<E> implements DbContext<E> {
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        // TODO check if thos is @Entity class
        Field idField = getIdField(entity);
        int id = getIdFieldValue(entity, idField);

        if(id == 0) {
//            return true;
            return doInsert(entity);
        } else {
            return false;
//            return doUpdate(entity);
        }
    }

    private boolean doInsert(E entity) throws SQLException {
        String insertTemplate = "INSERT INTO %s (%s) VALUES (%s)";
        String tableName = getTableName(entity.getClass());
        String columnNames = getColumnNamesWithoutId(entity);
        String values = getValuesWithoutId(entity);
        String sql = String.format(insertTemplate, tableName, columnNames, values);

        return this.connection.prepareStatement(sql).executeUpdate() > 0;
    }

    private String getValuesWithoutId(E entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .filter(field -> !field.isAnnotationPresent(Id.class))
                .map(field -> {
                    try {
                        field.setAccessible(true);
                        return field.get(entity);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(Object::toString)
                .map(s -> "'" + s + "'")
                .collect(Collectors.joining(","));
    }

//    TODO: add default if name in @Column is not set
    private String getColumnNamesWithoutId(E entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .filter(field -> !field.isAnnotationPresent(Id.class))
                .map(field -> field.getAnnotation(Column.class).name())
                .collect(Collectors.joining(","));
    }

    private String getTableName(Class<?> clazz) {
        Entity annotation = clazz.getAnnotation(Entity.class);
        if (annotation == null) {
            throw new ORMException("Entity class must be annotated with @Entity");
        }
        else {
            return annotation.name();
        }
    }

    private int getIdFieldValue(E entity, Field idField) throws IllegalAccessException {
        idField.setAccessible(true);
        Object value = idField.get(entity);
        return  0;
    }

    private Field getIdField(E entity) {
        Optional<Field> idField = Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(org.example.orm.annotations.Id.class))
                .findFirst();
        if(idField.isEmpty()) {
            throw new ORMException("Entity without @Id field");
        }
        return idField.get();
    }

    @Override
    public Iterable<E> find(Class<E> clazz) {
        return find(clazz, null);
    }

    @Override
    public Iterable<E> find(Class<E> clazz, String where) {
        return null;
    }

    @Override
    public E findFirst(Class<E> clazz) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return findFirst(clazz, null);
    }

    @Override
    public E findFirst(Class<E> clazz, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String selectQuery = "SELECT * FROM %s %s LIMIT 1";
        String tableName = getTableName(clazz);
        String computedWhere = where == null ? "" : "WHERE " + where;

        String sql = String.format(selectQuery, tableName, computedWhere);
         ResultSet result = connection.prepareStatement(sql).executeQuery();

        boolean hasElement = result.next();
        if(!hasElement) {
            return null;
        }

        return fillEntity(result, clazz);
    }

    private E fillEntity(ResultSet result, Class<E> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        create new object
        E resultEntity = clazz.getConstructor().newInstance();
        Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .forEach(f -> {
                    try {
                        fillField(resultEntity, result, f);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });

//        fill field from result set
        return resultEntity;
    }

    private void fillField(E entity, ResultSet result, Field field) throws SQLException, IllegalAccessException {
        String columnName = field.getAnnotation(Column.class).name();
        String fieldValue = result.getString(columnName);
        Object value = getValueWithCorrectType(field.getType(), fieldValue);

        field.setAccessible(true);
        field.set(entity, value);
    }

    private Object getValueWithCorrectType(Class<?> type, String dbValue) {
        if(type == int.class || type == Integer.class) {
            return Integer.parseInt(dbValue);
        } else if(type == String.class) {
            return dbValue;
        } else if(type == LocalDate.class) {
            return LocalDate.parse(dbValue);
        } else if(type == double.class || type == Double.class) {
            return Double.parseDouble(dbValue);
        } else if(type == float.class || type == Float.class) {
            return Float.parseFloat(dbValue);
        } else if(type == long.class || type == Long.class) {
            return Long.parseLong(dbValue);
        }

        throw new ORMException("Unsupported field type: " + type.getName());
    }
}
