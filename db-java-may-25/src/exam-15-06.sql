drop schema car_rental_companies;
create schema car_rental_companies;
use car_rental_companies;

# 1 DDL
create table cities
(
    id int primary key auto_increment,
    name varchar(40) not null unique
);

create table cars
(
    id int primary key auto_increment,
    brand varchar(20) not null,
    model varchar(20) not null unique
);

create table lessors
(
    id int primary key auto_increment,
    first_name varchar(40) not null,
    last_name varchar(40) not null unique,
    company_employee_from date not null
);

create table rental_companies
(
    id int primary key auto_increment,
    name varchar(40) not null unique,
    cross_border_usage boolean not null,
    price_per_day decimal(10, 2),
    car_id int not null,
    city_id int not null,
    foreign key (car_id) references cars(id),
    foreign key (city_id) references cities(id)
);

create table renters
(
    id int primary key auto_increment,
    first_name varchar(40) not null,
    last_name varchar(40) not null unique,
    age int,
    phone_number varchar(20) unique
);

create table lessors_rental_companies
(
    lessor_id int,
    rental_company_id int not null,
#     primary key (lessor_id, rental_company_id),
    foreign key (lessor_id) references lessors(id),
    foreign key (rental_company_id) references rental_companies(id)
);

create table lessors_renters
(
    lessor_id int not null,
    renter_id int not null,
#     primary key (lessor_id, renter_id),
    foreign key (lessor_id) references lessors(id),
    foreign key (renter_id) references renters(id)
);

INSERT INTO cities (id, name)
VALUES (1, 'Dundee'),
       (2, 'Glasgow'),
       (3, 'Aberdeen'),
       (4, 'Leeds'),
       (5, 'London'),
       (6, 'Nottingham'),
       (7, 'Liverpool'),
       (8, 'Manchester'),
       (9, 'Birmingham'),
       (10, 'Bradford'),
       (11, 'Peterhead'),
       (12, 'Gosport'),
       (13, 'Canterbury'),
       (14, 'Kirkcaldy'),
       (15, 'Worcester');

INSERT INTO cars (brand, model)
VALUES ('Toyota', 'Camry'),
       ('Honda', 'Civic'),
       ('Ford', 'Focus'),
       ('Chevrolet', 'Malibu'),
       ('Nissan', 'Altima'),
       ('BMW', '3 Series'),
       ('Audi', 'A4'),
       ('Mercedes-Benz', 'C-Class'),
       ('Volkswagen', 'Jetta'),
       ('Hyundai', 'Sonata'),
       ('Kia', 'Optima'),
       ('Subaru', 'Impreza'),
       ('Mazda', 'Mazda3'),
       ('Lexus', 'ES'),
       ('Acura', 'TLX'),
       ('Infiniti', 'Q50'),
       ('Cadillac', 'ATS'),
       ('Buick', 'Regal'),
       ('GMC', 'Terrain'),
       ('Jeep', 'Cherokee'),
       ('Chrysler', '300'),
       ('Dodge', 'Charger'),
       ('Dodge', 'Ram'),
       ('Ford', 'Mustang'),
       ('Chevrolet', 'Camaro'),
       ('Toyota', 'Corolla'),
       ('Honda', 'Accord'),
       ('Subaru', 'Outback'),
       ('Nissan', 'Rogue'),
       ('Hyundai', 'Elantra');

INSERT INTO lessors (first_name, last_name, lessors.company_employee_from)
VALUES ('John', 'Doe', '1980-01-01'),
       ('Jane', 'Smith', '1981-05-01'),
       ('Michael', 'Johnson', '1990-11-01'),
       ('Emily', 'Brown', '2000-10-01'),
       ('William', 'Jones', '1980-02-01'),
       ('Jessica', 'Davis', '2001-03-01'),
       ('Daniel', 'Miller', '1986-01-23'),
       ('Sarah', 'Wilson', '1995-01-14'),
       ('David', 'Taylor', '2005-01-15'),
       ('Laura', 'Anderson', '2011-01-14'),
       ('Matthew', 'Thomas', '2000-01-24'),
       ('Jennifer', 'Jackson', '2020-01-22'),
       ('Christopher', 'White', '1998-01-17'),
       ('Ashley', 'Harris', '2003-01-18'),
       ('Jessica', 'Martin', '2004-01-30'),
       ('Robert', 'Thompson', '2002-04-01'),
       ('Amanda', 'Garcia', '2005-05-01'),
       ('James', 'Martinez', '2013-06-01'),
       ('Brittany', 'Robinson', '2014-07-01'),
       ('Andrew', 'Clark', '2016-07-01'),
       ('Melissa', 'Lewis', '2006-08-01'),
       ('Justin', 'Lee', '2001-01-01'),
       ('Stephanie', 'Walker', '1999-01-22'),
       ('Jonathan', 'Perez', '2002-01-14'),
       ('Nicole', 'Hall', '2000-01-13'),
       ('Brandon', 'Young', '2007-01-26'),
       ('Heather', 'Allen', '2022-01-25'),
       ('Eric', 'Sanchez', '2015-01-25'),
       ('Samantha', 'Wright', '2017-11-01'),
       ('Kyle', 'King', '2018-11-01'),
       ('Elizabeth', 'Scott', '2019-10-01'),
       ('Tyler', 'Green', '1996-11-01'),
       ('Alex', 'Leen', '1998-12-01'),
       ('Nahtim', 'Djaravan', '1986-11-01'),
       ('Naim', 'Suleiman', '1997-12-01'),
       ('Hasan', 'Hasan', '1999-04-08'),
       ('Mohamed', 'Grinbati', '1999-05-09'),
       ('Mustafa', 'Mehmed', '1993-03-03'),
       ('Rojer', 'Tacher', '1994-06-01'),
       ('Paul', 'Hogan', '1991-09-06'),
       ('Rebecca', 'Baker', '1982-06-01');

INSERT INTO rental_companies (name, cross_border_usage, price_per_day, car_id, city_id)
VALUES ('AJK Car Rentals', 1, 69.99, 23, 15),
       ('AK Auto Hire', 1, 69.99, 30, 6),
       ('ALAM Rentals', 1, 69.99, 12, 5),
       ('AM Auto Rent', 0, 69.00, 13, 15),
       ('APOLLO Car Hire', 1, 69.99, 16, 4),
       ('AQ4 Car Rentals', 0, 56.99, 2, 4),
       ('AS Vehicle Rentals', 1, 45.99, 4, 3),
       ('ASK Car Hire', 1, 55.99, 2, 3),
       ('ASM Car Leasing', 1, 87.99, 5, 3),
       ('AZIRATI Car Services', 0, 78.99, 6, 12),
       ('Aapass Auto Rentals', 1, 76.99, 7, 11),
       ('Able2Drive Rentals', 1, 66.99, 8, 13),
       ('Agnew Car Rentals', 0, 88.99, 9, 14),
       ('Ahmed Auto Hire', 0, 30.99, 19, 5),
       ('Ailsa''s Car Hire', 1, 54.99, 22, 1),
       ('Alan Henderson Rentals', 1, 53.99, 21, 14),
       ('Alan Stevens Cars', 1, 67.45, 25, 12),
       ('Alan Street Rentals', 1, 69.00, 27, 12),
       ('Alba Auto Hire', 1, 70.99, 28, 3),
       ('Albys Car Rentals', 1, 60.99, 29, 2),
       ('Alisons Auto Hire', 0, 60.00, 30, 2),
       ('Alpha Auto Rentals', 1, 68.00, 14, 4),
       ('ComeDrive Rentals', 1, 82.00, 23, 7),
       ('Confident Car Rentals', 1, 83.00, 16, 7),
       ('Coolrunnings Rentals', 1, 89.00, 1, 7),
       ('Drive & Rent', 1, 86.00, 2, 1),
       ('DriveAuto Hire', 1, 110.00, 5, 7),
       ('Wright Car Rentals', 1, 100.00, 6, 3),
       ('Drive2Go Rentals', 1, 49.00, 26, 2),
       ('Drive4Life Rentals', 1, 56.00, 22, 2),
       ('EV L Rentals', 1, 80.00, 3, 1),
       ('Empire Auto Hire', 1, 78.00, 9, 15),
       ('Evie Rentals', 1, 60.00, 8, 14),
       ('Fiona Auto Hire', 1, 80.00, 5, 7),
       ('Ford Car Hire', 1, 90.00, 4, 12),
       ('Freedom Rentals', 1, 65.00, 7, 7),
       ('Full Circle Car Hire', 1, 66.00, 9, 11),
       ('GGO Auto Rentals', 1, 55.00, 7, 7),
       ('GILL''s Auto Rentals', 1, 59.00, 6, 13),
       ('Got2Rent', 1, 70.00, 16, 7),
       ('Gus Caledonian Rentals', 1, 90.00, 15, 7),
       ('Tomcat Rentals', 1, 98.00, 18, 7),
       ('Hotwheelz Rentals', 1, 89.00, 21, 5),
       ('Horgis Car Hire', 1, 30.00, 20, 4),
       ('I-Drive Rentals', 1, 33.00, 11, 2),
       ('Igo Auto Rentals', 1, 44.00, 13, 3),
       ('JFK Auto Hire', 1, 27.00, 10, 7),
       ('Jewel Auto Rentals', 1, 54.00, 10, 6),
       ('Jigsaw Car Hire', 1, 26.00, 1, 10),
       ('KP Auto Rentals', 1, 43.00, 25, 11),
       ('KAR-n-RENT', 1, 34.00, 18, 4),
       ('JustDrive Rentals', 1, 29.00, 24, 5),
       ('Top Car Rentals', 0, 80.00, 23, 7),
       ('LEAP Car Hire', 1, 65.00, 27, 8),
       ('King Auto Rentals', 1, 37.00, 6, 9),
       ('LambertвЂ™s Rentals', 1, 56.50, 7, 1),
       ('Learn2Drive Rentals', 0, 80.60, 8, 4),
       ('Mentords Car Hire', 1, 35.00, 1, 13),
       ('OK 4U Rentals', 1, 36.00, 18, 7),
       ('OK-2-GO Rentals', 1, 43.00, 2, 7),
       ('OneDrive Rentals', 1, 35.00, 9, 12),
       ('PassIt Rentals', 1, 39.00, 11, 5),
       ('Practical Auto Hire', 0, 65.00, 10, 7),
       ('Progressive Rentals', 1, 23.00, 9, 7),
       ('Roadsense Rentals', 1, 45.00, 8, 7),
       ('Roadstar Auto Hire', 0, 54.00, 8, 4),
       ('Shawpass Rentals', 1, 46.00, 18, 7),
       ('Skyline Rentals', 0, 47.00, 12, 7),
       ('iQ Auto Hire', 1, 28.00, 1, 1);



INSERT INTO renters (first_name, last_name, age, phone_number)
VALUES ('Peter', 'Schultz', 20, '123-456-7890'),
       ('Jakomo', 'Indarasi', 22, '987-654-3210'),
       ('Michael', 'Pinch', 19, '323-123-4567'),
       ('Emily', 'Lynch', 21, '212-838-1546'),
       ('David', 'Williams', 23, '198-312-6666'),
       ('William', 'Taylor', 20, '111-222-3333'),
       ('James', 'Anderson', 22, '666-777-3245'),
       ('Jessica', 'Schlemiel', 21, '333-444-5555'),
       ('Robert', 'Fernandez', 19, '888-999-2765'),
       ('Jennifer', 'Garcia', 24, '262-333-4444'),
       ('Christopher', 'Lopez', 20, '121-325-6500'),
       ('Mary', 'Young', 23, '100-389-7777'),
       ('Matthew', 'Brown', 21, '329-111-2222'),
       ('Amanda', 'Lee', 22, '717-838-4554'),
       ('Daniel', 'Walker', 20, '333-444-2312'),
       ('Ashley', 'Hill', 19, '828-999-2342'),
       ('Andrew', 'Scott', 21, '323-333-4444'),
       ('Emily', 'Green', 24, '765-143-1221'),
       ('David', 'Sahan', 33, '145-656-7654'),
       ('Sarah', 'Bakers', 22, '987-121-5436'),
       ('Ryan', 'Nelson', 21, '787-878-5674'),
       ('Jessica', 'White', 19, '710-444-1112'),
       ('Michael', 'Carter', 23, '234-999-1265'),
       ('Nelson', 'Evans', 38, '222-333-4444'),
       ('John', 'Perez', 22, '959-909-1145'),
       ('Jennifer', 'Mitchell', 21, '963-666-7898'),
       ('Kevin', 'Roberts', 40, '147-111-2222'),
       ('Michelle', 'Turner', 24, '983-888-1211'),
       ('Matthew', 'Phillips', 20, '333-444-4545'),
       ('Emily', 'Mandela', 23, '866-919-1122'),
       ('David', 'Parker', 21, '564-313-3900'),
       ('Jim', 'Allen', 22, '543-786-1111'),
       ('Christopher', 'Stewart', 44, '112-666-5465'),
       ('Ashley', 'Morrison', 34, '356-102-1432'),
       ('Michael', 'Cook', 24, '809-888-1587'),
       ('Jennifer', 'Bailey', 21, '333-444-963'),
       ('Sarah', 'Cooper', 23, '201-999-2435'),
       ('Matthew', 'Sanchez', 20, '222-333-3478'),
       ('Jessica', 'Morris', 22, '109-000-1234'),
       ('David', 'Rogers', 46, '678-606-1209'),
       ('Andrew', 'Peterson', 24, '101-111-2909'),
       ('Michelle', 'Foster', 29, '985-808-1993'),
       ('Laura', 'Long', 21, '301-444-1981'),
       ('John', 'Harrison', 23, '120-999-4512'),
       ('Jennifer', 'James', 20, '212-321-4094'),
       ('Matthew', 'Bennett', 22, '203-020-1111'),
       ('Jessica', 'Reed', 39, '031-666-2176');

INSERT INTO lessors_rental_companies
VALUES (1, 2),
       (2, 1),
       (3, 11),
       (4, 69),
       (5, 10),
       (6, 46),
       (7, 54),
       (8, 14),
       (9, 35),
       (10, 63),
       (11, 4),
       (12, 41),
       (13, 55),
       (14, 67),
       (15, 9),
       (16, 1),
       (17, 18),
       (18, 41),
       (19, 10),
       (20, 31),
       (21, 51),
       (22, 27),
       (23, 16),
       (24, 32),
       (25, 45),
       (26, 10),
       (27, 10),
       (28, 10),
       (29, 12),
       (30, 11),
       (31, 28),
       (32, 53),
       (33, 56),
       (34, 57),
       (35, 68),
       (36, 47),
       (37, 30),
       (38, 7),
       (39, 2),
       (40, 3),
       (41, 6);

INSERT INTO lessors_renters (lessor_id, renter_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (6, 6),
       (7, 7),
       (8, 8),
       (9, 9),
       (10, 10),
       (11, 11),
       (12, 12),
       (13, 13),
       (14, 14),
       (15, 15),
       (16, 16),
       (17, 17),
       (18, 18),
       (19, 19),
       (20, 20),
       (21, 21),
       (22, 22),
       (23, 23),
       (24, 24),
       (25, 25),
       (26, 26),
       (27, 27),
       (28, 28),
       (29, 29),
       (30, 30),
       (31, 31),
       (32, 32),
       (33, 33),
       (34, 34),
       (35, 35),
       (36, 36),
       (37, 37),
       (38, 38),
       (39, 39),
       (40, 40),
       (41, 41),
       (1, 42),
       (13, 43),
       (30, 44),
       (16, 45),
       (21, 46),
       (40, 47);


# 2 DML
insert into renters (first_name, last_name, age, phone_number)
select reverse(lower(first_name)),
       reverse(lower(last_name)),
       age + left(phone_number, 1) age,
       concat('1+', phone_number) phone_number
from renters
where age < 20;

update rental_companies
set price_per_day = price_per_day + 30
where city_id = 5
    and cross_border_usage = true;

delete from rental_companies
where cross_border_usage = false;

# 3 Querying

select concat(first_name, ' ', last_name) full_name,
       age
from renters
where first_name like '%a%'
and age <=  all(select age from renters)
order by id;

select rc.id id, rc.name name, c.brand brand
from rental_companies rc
join cars c on rc.car_id = c.id
left join lessors_rental_companies lrc on rc.id = lrc.rental_company_id
where lrc.lessor_id is null
order by c.brand, rc.id
limit 5;

select first_name, last_name, count(*) renters_count, c.name city
from lessors l
join lessors_renters lr on l.id = lr.lessor_id
join lessors_rental_companies lrc on l.id = lrc.lessor_id
join rental_companies rc on lrc.rental_company_id = rc.id
join cities c on rc.city_id = c.id
group by first_name, last_name, c.name
having renters_count > 1
order by renters_count desc, first_name;

select c.name name,
       count(*) lessor_count
from cities c
join rental_companies rc on c.id = rc.city_id
join lessors_rental_companies lrc on rc.id = lrc.rental_company_id
group by c.name
order by lessor_count desc;

select concat(first_name, ' ', last_name) full_name,
       case
           when year(company_employee_from) < 1990 then 'Specialist'
           when year(company_employee_from) < 2000 then 'Advanced'
           when year(company_employee_from) < 2008 then 'Experienced'
           when year(company_employee_from) < 2015 then 'Qualified'
           when year(company_employee_from) < 2020 then 'Provisional'
           else 'Trainee'
        end level
from lessors
order by year(company_employee_from), first_name;

# 4 func and proc programmability
create function
    udf_average_price_by_city (city_name VARCHAR(40))
    returns decimal(19, 2)
not deterministic
reads sql data
return
    (
    select round(avg(rc.price_per_day), 2) average_price_per_day
    from rental_companies rc
    join cities c on rc.city_id = c.id
    where c.name = city_name
    );

SELECT c.name, udf_average_price_by_city ('Liverpool') as average_price_per_day
FROM cities c
WHERE c.name = 'Liverpool'


create procedure
    udp_find_rental_company_by_car (brand VARCHAR(20))
select name, price_per_day
from rental_companies rc
join cars c on rc.car_id = c.id
where c.brand = brand
order by price_per_day desc;



