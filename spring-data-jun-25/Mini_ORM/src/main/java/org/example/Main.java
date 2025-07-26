package org.example;

import org.example.entities.Order;
import org.example.entities.User;
import org.example.orm.EntityManager;
import org.example.orm.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.E  xecute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

        User user = new User("cholakov", 25, java.time.LocalDate.now());
        Order order = new Order(100.0, LocalDate.now());

        MyConnector.createConnection("root", "azisevelik", "mini_orm");
        Connection connection = MyConnector.getConnection();

        EntityManager<User> userEm = new EntityManager<>(connection);
        EntityManager<Order> orderEm = new EntityManager<>(connection);

        userEm.persist(user);
        orderEm.persist(order);

        User fromDb = userEm.findFirst(User.class, "id = 2");
//        User fromDb2 = userEm.findFirst(User.class);

//        Order first = orderEm.findFirst(Order.class);

//        System.out.println(first.getOrderId());
//        Order first = orderEm.findFirst(Order.class);
//        System.out.println(first.getOrderId());

//        Iterable<User> users = userEm.find(User.class);
//        users.forEach(u -> System.out.println(u.getUsername()));

        fromDb.setUsername("edited_2nd");
        userEm.persist(fromDb);
    }
}