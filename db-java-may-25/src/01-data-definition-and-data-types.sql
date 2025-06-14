# 01 db intro data def and data types
create schema minions;
use minions;

drop table minions;
drop table towns;

create table minions (
    id INT PRIMARY KEY auto_increment,
    name VARCHAR(40),
    age INT
);

create table towns (
    town_id INT PRIMARY KEY auto_increment,
    name VARCHAR(40)
);
ALTER TABLE minions
     modify age INT NULL;

ALTER TABLE minions
     modify age INT NULL;

alter table towns
rename  column town_id to id;

alter table minions
add town_id INT;

alter table minions
add constraint fk_minions_towns
    foreign key (town_id) REFERENCES towns(id);

insert into towns
values (1, 'Sofia'),
       (2, 'Plovdiv'),
       (3, 'Varna')
;

INSERT INTO minions
VALUES (1, 'Kevin', 22, 1),
       (2, 'Bob', 15, 3),
       (3, 'Steward', null, 2)
;

truncate minions;

drop table minions;
drop table towns;

create table people (
    id int primary key auto_increment,
    name varchar(200) not null,
    picture longblob,
    height decimal(3, 2),
    weight decimal (5, 2),
    gender ENUM('m', 'f') not null,
    birthdate date not null,
    biography longtext
);

insert into people (name, picture, height, weight, gender, birthdate, biography)
values ('aaa', null, 1.81, 71, 'm', '2020-02-01', null),
       ('bbb', null, 1.82, 72, 'm', '2020-02-02', null),
       ('ccc', null, 1.83, 73, 'm', '2020-02-03', null),
       ('ddd', null, 1.84, 74, 'm', '2020-02-04', null),
       ('eee', null, 1.85, 75, 'm', '2020-02-05', null);

create table users (
    id bigint primary key auto_increment,
    username varchar(30) character set ascii unique not null,
    password varchar(26) character set ascii not null,
    profile_picture mediumblob,
    last_login_time datetime,
    is_deleted bool
);

insert into users
values (null, "tomato1", "tmasdt1", null, "2025-06-06 22:22:22", false),
       (null, "tomato2", "tmasdt2", null, "2025-06-06 22:22:22", false),
       (null, "tomato3", "tmasdt3", null, "2025-06-06 22:22:22", false),
       (null, "tomato4", "tmasdt4", null, "2025-06-06 22:22:22", false),
       (null, "tomato5", "tmasdt5", null, "2025-06-06 22:22:22", false);

select * from users;

ALTER TABLE users
  DROP PRIMARY KEY,
add constraint pk_users primary key (id, username);

ALTER TABLE users
  DROP PRIMARY KEY;

ALTER TABLE users
  MODIFY COLUMN last_login_time DATETIME
    DEFAULT CURRENT_TIMESTAMP;


alter table users
modify last_login_time datetime default now();

show keys from users where key_name = 'PRIMARY';

alter table users
  DROP PRIMARY KEY,
add constraint pk_users primary key (id),
modify column username varchar(30) character set ascii unique not null;

alter table users
  DROP PRIMARY KEY,
add constraint pk_users primary key (id),
add constraint unq_users_username unique(username);

create schema movies;
use movies;

create table directors (
    id int primary key auto_increment,
    director_name varchar(100) not null,
    notes varchar(1000)
);

create table genres (
    id int primary key auto_increment,
    genre_name varchar(30) not null,
    notes varchar(1000)
);

# create table categories (
#     id int primary key auto_increment,
#     category_name varchar(30) not null,
#     notes varchar(1000)
# );

create table movies (
    id int primary key auto_increment,
    title varchar(100) not null,
    director_id int,
    copyright_year int,
    length int,
    genre_id int,
    category_id int,
    rating decimal(5,2),
    notes varchar(1000)
);

insert into directors
values (1, "aaa", "notes"),
       (2, "bbb", "notes"),
       (3, "ccc", "notes"),
       (4, "ddd", "notes"),
       (5, "eee", "notes");

insert into genres
values (1, "thriller", "notes"),
       (2, "comedy", "notes"),
       (3, "romance", "notes"),
       (4, "fantasy", "notes"),
       (5, "science fiction", "notes");

insert into categories
values (1, "animation", "notes"),
       (2, "documentary", "notes"),
       (3, "mocumentary", "notes"),
       (4, "test2", "notes"),
       (5, "test3", "notes");

insert into movies
values (1, "star wars", 1, 1990, 120, 2,2, 4.5, "notes"),
       (2, "the man from earth", 1, 1990, 120, 2,2, 4.5, "notes"),
       (3, "man on the moon", 1, 1990, 120, 2,2, 4.5, "notes"),
       (4, "blue valentine", 1, 1990, 120, 2,2, 4.5, "notes"),
       (5, "beetlegeuse", 1, 1990, 120, 2,2, 4.5, "notes");


create schema car_rental;
use car_rental;

create table categories (
    id int primary key auto_increment,
    category varchar(30) not null,
    daily_rate decimal(9,2),
    weekly_rate decimal(9,2),
    monthly_rate decimal(9,2),
    weekend_rate decimal(9,2)
);

create table cars (
    id int primary key auto_increment,
    plate_number varchar(10) not null,
    make varchar(10),
    model varchar(20),
    car_year int,
    category_id int,
    doors int,
    picture blob,
    car_condition varchar(10),
    available bool
);


create table employeess (
    id int primary key auto_increment,
    first_name varchar(15) not null,
    last_name varchar(15) not null,
    title varchar(10),
    notes varchar(100)
);

create table customers (
    id int primary key auto_increment,
    driver_licence_number varchar(10) not null,
    full_name varchar(50),
    address varchar(100),
    city varchar(20),
    zip_code int,
    notes varchar(100)
);

create table rental_orders (
    id int primary key auto_increment,
    employee_id int,
    customer_id int,
    car_id int,
    car_condition varchar(10),
    tank_level int,
    kilometrage_start int,
    kilometrage_end int,
    total_kilometrage int,
    start_date date,
    end_date date,
    total_days int,
    rate_applied decimal(9,2),
    tax_rate int,
    order_status varchar(10),
    notes varchar(100)
);

insert into categories (category)
values ("aaa"),
       ("bbb"),
       ("ccc");

insert into cars (plate_number)
values (1234),
       (1235),
       (1236);

insert into employees (first_name, last_name)
values ("a", "aa"),
       ("b", "bb"),
       ("c", "cc");

insert into customers (driver_licence_number)
values (12345),
       (123),
       (123);
insert into rental_orders (id)
values (1),
       (2),
       (3);


insert into categories
values (1, "aaa", 4.5, 4.5, 4.5, 4.5),
       (2, "bbb", 4.5, 4.5, 4.5, 4.5),
       (3, "ccc", 4.5, 4.5, 4.5, 4.5);


#############################
    # softuni db #
#############################

create schema soft_uni;
use soft_uni;
create table towns (
    id int primary key auto_increment,
    name varchar(20) not null
);

create table addresses(
    id int primary key auto_increment,
    address_text varchar(100) not null,
    town_id int
);

create table departments (
    id int primary key auto_increment,
    name varchar(30) not null
);

create table employees (
    id int primary key auto_increment,
    first_name varchar(15) not null,
    middle_name varchar(15),
    last_name varchar(15) not null ,
    job_title varchar(20),
    department_id int,
    hire_date date,
    salary decimal(20,2),
    address_id int
);

insert into towns (name)
values ("Sofia"),
       ("Plovdiv"),
       ("Varna"),
       ("Burgas");

insert into departments (name)
values ("Engineering"),
       ("Sales"),
       ("Marketing"),
       ("Software Development"),
       ("Quality Assurance");

insert into employees (first_name, middle_name, last_name, job_title, department_id, hire_date, salary)
values ("Ivan", "Ivanov", "Ivanov", ".NET Developer", 4,"2013-02-01", 3500.00),
       ("Petar","Petrov",  "Petrov", "Senior Engineer", 1,"2004-03-02", 4000.00),
       ("Maria", "Petrova",  "Ivanova", "Intern", 5,"2016-08-28", 525.25),
       ("Georgi", "Terziev", "Ivanov", "CEO", 2,"2007-12-09", 3000.00),
       ("Peter",  "Pan",  "Pan", "Intern", 3,"2016-08-28", 599.88);


select name from towns order by name;
select name from departments order by name;
select first_name, last_name, job_title, salary from employees order by salary desc;

UPDATE employees
set salary = salary * 1.1;

select salary from employees;



