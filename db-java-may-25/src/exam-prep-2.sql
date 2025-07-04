# https://alpha.judge.softuni.org/contests/databases-basics-mysql-retake-exam-6-december-2024/5082

drop schema foods_friends;
create schema foods_friends;
use foods_friends;

# 1 DDL
create table restaurants
(
    id int primary key auto_increment,
    name varchar(40) not null unique,
    type varchar(20) not null,
    non_stop boolean not null
);

create table offerings (
    id int primary key auto_increment,
    name varchar(40) not null unique,
    price decimal(19,2) not null,
    vegan boolean not null,
    restaurant_id int not null,
    foreign key (restaurant_id) references restaurants(id)
);

create table customers (
    id int primary key auto_increment,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    phone_number varchar(20) not null unique,
    regular boolean not null,
    constraint unique (first_name, last_name)
);

create table orders (
    id int primary key auto_increment,
    number varchar(10) not null unique,
    priority varchar(10) not null,
    customer_id int not null,
    restaurant_id int not null,
    foreign key (customer_id) references customers(id),
    foreign key (restaurant_id) references restaurants(id)
);

create table orders_offerings(
    order_id int not null,
    offering_id int not null,
    restaurant_id int not null,
    primary key (order_id, offering_id),
    foreign key (order_id) references orders(id),
    foreign key (offering_id) references offerings(id),
    foreign key (restaurant_id) references restaurants(id)
);

INSERT INTO restaurants (name, type, non_stop)
VALUES ('Burger Haven', 'fast food', true),
       ('Pizza Palace', 'pizzeria', false),
       ('The Bread Basket', 'bakery', true),
       ('Bistro Delight', 'bistro', false),
       ('Buffet World', 'buffet', true),
       ('The Pub Corner', 'pub', false),
       ('La Fine Dine', 'fine dining', true),
       ('Taco Spot', 'fast food', false),
       ('Pasta Perfection', 'pizzeria', true),
       ('Sweet Treats', 'bakery', false),
       ('The Fishery', 'fish restaurant', false),
       ('Seafood Shack', 'fish restaurant', true),
       ('Grill masters', 'grill', true),
       ('Neptune\'s Catch', 'fish restaurant', false),
       ('Sushi Central', 'buffet', false),
       ('The Cozy Ale', 'pub', true),
       ('Elegant Bites', 'fine dining', false),
       ('Ocean Bites', 'fish restaurant', true),
       ('Blue Water Grill', 'fish restaurant', true),
       ('Wrap City', 'fast food', true),
       ('Pizza Lovers', 'pizzeria', false),
       ('Tidal Tastes', 'fish restaurant', false),
       ('Cupcake Heaven', 'bakery', true),
       ('Whale\'s Belly', 'fish restaurant', true),
       ('Urban Diner', 'bistro', false),
       ('Orange Grove Road', 'buffet', true),
       ('The Rustic Pub', 'pub', false),
       ('The Grill House', 'grill', true),
       ('Captain\'s Catch', 'fish restaurant', true),
       ('Pasta Mania', 'pizzeria', false),
       ('Poseidon\'s Plate', 'fish restaurant', true),
       ('The Croissant Corner', 'bakery', true),
       ('Fisherman\'s Delight', 'fish restaurant', false),
       ('The Local Tavern', 'pub', false),
       ('Fancy Feast', 'fine dining', true),
       ('Burger Station', 'fast food', false),
       ('Pizza Express', 'pizzeria', true),
       ('The Breakfast Nook', 'bistro', false),
       ('Cupcake Dreams', 'bakery', true),
       ('The Wine Cellar', 'fine dining', false)
;

INSERT INTO offerings (name, price, vegan, restaurant_id)
VALUES
      ('Beef Hot Burger', 9.99, false, 1),
      ('Chicken Nuggets', 5.99, false, 1),
      ('Veggie Burger', 7.50, true, 1),
      ('Cheeseburger', 8.50, false, 8),
      ('Spicy Chicken Sandwich', 7.20, false, 8),
      ('French Fries', 3.99, true, 8),
      ('Double Bacon Burger', 12.50, false, 20),
      ('Onion Rings', 4.50, true, 20),
      ('Grilled Chicken Wrap', 6.80, false, 36),
      ('Margherita Pizza', 11.50, true, 2),
      ('Pepperoni Pizza', 12.99, false, 2),
      ('Four Cheese Pizza', 13.99, true, 9),
      ('Hawaiian Pizza', 14.50, false, 9),
      ('BBQ Chicken Pizza', 15.00, false, 21),
      ('Vegan Veggie Pizza', 13.75, true, 21),
      ('Meat Lovers Pizza', 16.50, false, 30),
      ('Buffalo Chicken Pizza', 15.99, false, 37),
      ('Chocolate Croissant', 3.99, true, 3),
      ('Blueberry Muffin', 2.99, true, 3),
      ('Bagel with Cream Cheese', 4.50, false, 10),
      ('Cinnamon Roll', 4.00, true, 10),
      ('Sourdough Bread', 5.50, true, 23),
      ('Raspberry Danish', 3.75, true, 23),
      ('Chocolate Chip Cookie', 2.50, true, 29),
      ('Lemon Tart', 4.80, true, 32),
      ('Apple Pie', 5.99, true, 32),
      ('Banana Bread', 4.25, true, 39),
      ('Grilled Cheese Sandwich', 6.50, true, 4),
      ('Tomato Soup', 4.99, true, 4),
      ('Caesar Salad', 8.99, false, 25),
      ('Steak Frites', 18.50, false, 25),
      ('Caprese Salad', 7.75, true, 38),
      ('Roast Beef', 16.99, false, 5),
      ('Cauliflower Gratin', 10.50, true, 5),
      ('Mashed Potatoes', 5.50, true, 15),
      ('Chicken Alfredo', 14.99, false, 15),
      ('Baked Ziti', 12.50, false, 26),
      ('Fried Chicken', 11.99, false, 26),
      ('Fish and Chips', 12.99, false, 6),
      ('Shepherd\'s Pie', 14.50, false, 6),
      ('Buffalo Wings', 9.99, false, 16),
      ('Nachos', 7.99, true, 16),
      ('Bangers and Mash', 13.50, false, 27),
      ('Steak and Ale Pie', 15.99, false, 34),
      ('Filet Mignon', 39.99, false, 7),
      ('Truffle Risotto', 29.99, true, 7),
      ('Lobster Tail', 45.50, false, 17),
      ('Wild Mushroom Soup', 14.50, true, 17),
      ('Duck a l\'Orange', 35.99, false, 35),
      ('Tournedos Rossini', 42.99, false, 40),
      ('Grilled Salmon', 25.99, false, 11),
      ('Seared Scallops', 27.50, false, 11),
      ('Fish Tacos', 14.50, false, 12),
      ('Shrimp Scampi', 21.99, false, 12),
      ('Lobster Roll', 28.99, false, 14),
      ('Fried Oysters', 19.99, false, 14),
      ('Tuna Tartare', 24.50, false, 18),
      ('Seafood Paella', 32.99, false, 18),
      ('Crab Cakes', 22.50, false, 19),
      ('Grilled Swordfish', 29.50, false, 19),
      ('Mussels in White Wine Sauce', 19.75, false, 22),
      ('Grilled Octopus', 26.99, false, 24),
      ('Prawn Risotto', 23.99, false, 29),
      ('Baked Clams', 18.50, false, 31),
      ('Fish Stew', 20.99, false, 33),
      ('Grilled Pork Chops', 18.99, false, 13),
      ('BBQ Ribs', 24.50, false, 13),
      ('Chicken Skewers', 12.50, false, 28),
      ('Grilled Vegetables', 9.99, true, 28)
;

INSERT INTO customers (first_name, last_name, phone_number, regular)
VALUES ('Hasan', 'Ibrahim', '123-456-7890', true),
       ('Sarah', 'Johnson', '234-567-8901', false),
       ('Liam', 'Williams', '345-678-9012', true),
       ('Olivia', 'Brown', '456-789-0123', false),
       ('Emma', 'Jones', '567-890-1234', true),
       ('Noah', 'Garcia', '678-901-2345', false),
       ('James', 'Miller', '789-012-3456', true),
       ('Amelia', 'Davis', '890-123-4567', false),
       ('Mia', 'Rodriguez', '901-234-5678', true),
       ('Benjamin', 'Martinez', '012-345-6789', false),
       ('Sophia', 'Hernandez', '123-567-8901', true),
       ('Lucas', 'Lopez', '234-678-9012', false),
       ('Isabella', 'Gonzalez', '345-789-0123', true),
       ('Ethan', 'Wilson', '456-890-1234', false),
       ('Harper', 'Anderson', '567-901-2345', true),
       ('Alexander', 'Thomas', '678-012-3456', false),
       ('Ella', 'Moore', '789-123-4567', true),
       ('Aiden', 'Taylor', '890-234-5678', false),
       ('Scarlett', 'Jackson', '901-345-6789', true),
       ('Michael', 'Lee', '012-456-7890', false),
       ('Charlotte', 'Perez', '123-678-9012', true),
       ('Sebastian', 'Thompson', '234-789-0123', false),
       ('Avery', 'White', '345-890-1234', true),
       ('Samuel', 'Harris', '456-901-2345', false),
       ('Sofia', 'Sanchez', '567-012-3456', true),
       ('Daniel', 'Clark', '678-123-4567', false),
       ('Grace', 'Ramirez', '789-234-5678', true),
       ('Henry', 'Lewis', '890-345-6789', false),
       ('Riley', 'Walker', '901-456-7890', true),
       ('Matthew', 'Young', '012-678-9012', false),
       ('Ella', 'Allen', '123-789-0123', true),
       ('Levi', 'King', '234-890-1234', false),
       ('Aubrey', 'Wright', '345-901-2345', true),
       ('William', 'Scott', '456-012-3456', false),
       ('Lily', 'Torres', '567-123-4567', true),
       ('Mason', 'Nguyen', '678-234-5678', false),
       ('Hannah', 'Hill', '789-345-6789', true),
       ('Logan', 'Green', '890-456-7890', false),
       ('Chloe', 'Adams', '901-567-8901', true),
       ('Owen', 'Baker', '012-789-0123', false),
       ('Mila', 'Gonzalez', '123-890-1234', true),
       ('Eli', 'Nelson', '234-901-2345', false),
       ('Aria', 'Carter', '345-012-3456', true),
       ('Lucas', 'Mitchell', '456-123-4567', false),
       ('Zoe', 'Perez', '567-234-5678', true),
       ('Isaac', 'Roberts', '678-345-6789', false),
       ('Layla', 'Turner', '789-456-7890', true),
       ('Jacob', 'Phillips', '890-567-8901', false);

INSERT INTO orders (number, priority, customer_id, restaurant_id)
VALUES
    ('1234567890', 'LOW', 24, 1),
    ('9876543210', 'HIGH', 5, 2),
    ('1928374655', 'LOW', 12, 8),
    ('3748291045', 'HIGH', 37, 20),
    ('8273649102', 'LOW', 15, 36),
    ('1947582930', 'HIGH', 9, 9),
    ('3648271905', 'LOW', 25, 21),
    ('6582941039', 'HIGH', 32, 30),
    ('2837465921', 'LOW', 13, 37),
    ('1827364509', 'HIGH', 18, 3),
    ('4938271046', 'LOW', 8, 10),
    ('7291836450', 'HIGH', 26, 23),
    ('3918274650', 'LOW', 48, 29),
    ('8273648190', 'HIGH', 41, 32),
    ('1827365948', 'LOW', 36, 39),
    ('9182736450', 'HIGH', 14, 4),
    ('6758491023', 'LOW', 22, 25),
    ('4928371048', 'HIGH', 33, 38),
    ('0192837465', 'LOW', 45, 5),
    ('8374659283', 'HIGH', 10, 15),
    ('1029384756', 'LOW', 27, 26),
    ('9081726354', 'HIGH', 8, 6),
    ('2938475102', 'LOW', 19, 16),
    ('7384956102', 'HIGH', 13, 27),
    ('2837461902', 'LOW', 2, 34),
    ('1209384756', 'HIGH', 39, 7),
    ('3648192057', 'LOW', 4, 17),
    ('6573829102', 'HIGH', 12, 35),
    ('2837465922', 'LOW', 43, 40),
    ('1827364058', 'HIGH', 25, 11),
    ('8374659203', 'LOW', 6, 12),
    ('2039485712', 'HIGH', 31, 14),
    ('4738291024', 'LOW', 16, 18),
    ('1928374659', 'HIGH', 47, 19),
    ('2837461045', 'LOW', 40, 22),
    ('1928371057', 'HIGH', 18, 24),
    ('3847192058', 'LOW', 24, 29),
    ('1192837465', 'HIGH', 38, 31),
    ('3748291073', 'LOW', 7, 33),
    ('0192736458', 'HIGH', 11, 13),
    ('0981726354', 'LOW', 3, 28),
    ('1981726354', 'LOW', 3, 8);

INSERT INTO orders_offerings (order_id, offering_id, restaurant_id)
VALUES (1, 1, 1),
       (1, 2, 1),
       (1, 3, 1),
       (2, 10, 2),
       (3, 4, 8),
       (3, 5, 8),
       (3, 6, 8),
       (4, 7, 20),
       (4, 8, 20),
       (5, 9, 36),
       (6, 12, 9),
       (6, 13, 9),
       (7, 14, 21),
       (7, 15, 21),
       (8, 16, 30),
       (9, 17, 37),
       (10, 18, 3),
       (10, 19, 3),
       (11, 20, 10),
       (11, 21, 10),
       (12, 22, 23),
       (12, 23, 23),
       (13, 24, 29),
       (14, 25, 32),
       (14, 26, 32),
       (15, 27, 39),
       (16, 28, 4),
       (16, 29, 4),
       (17, 30, 25),
       (17, 31, 25),
       (18, 32, 38),
       (19, 33, 5),
       (19, 34, 5),
       (20, 35, 15),
       (20, 36, 15),
       (21, 37, 26),
       (21, 38, 26),
       (22, 39, 6),
       (22, 40, 6),
       (23, 41, 16),
       (23, 42, 16),
       (24, 43, 27),
       (25, 44, 34),
       (26, 45, 7),
       (26, 46, 7),
       (27, 47, 17),
       (27, 48, 17),
       (28, 49, 35),
       (29, 50, 40),
       (30, 51, 11),
       (30, 52, 11),
       (31, 53, 12),
       (31, 54, 12),
       (32, 55, 14),
       (32, 56, 14),
       (33, 57, 18),
       (33, 58, 18),
       (34, 59, 19),
       (34, 60, 19),
       (35, 61, 22),
       (36, 62, 24),
       (37, 63, 29),
       (38, 64, 31),
       (39, 65, 33),
       (40, 66, 13),
       (40, 67, 13),
       (41, 68, 28),
       (41, 69, 28),
       (42, 4, 8)
;

# 2 DML
insert into  offerings(name, price, vegan, restaurant_id)
select concat(name, ' costs:'),
       price,
       vegan,
       restaurant_id
from offerings
where name like 'grill%';

update offerings
set name = upper(name)
where name like '%pizza%';

delete
from restaurants
where name like '%fast%'
or type like '%fast%';


# 3 querying
select o.name, o.price
from offerings o
join restaurants r on o.restaurant_id = r.id
where r.name = 'Burger Haven'
order by o.id;

select c.id id, first_name, last_name
from customers c
left join orders o on c.id = o.customer_id
where o.id is null
order by c.id;

select off.id, off.name
from offerings off
join orders_offerings ordoff on off.id = ordoff.offering_id
join orders ord on ordoff.order_id = ord.id
join customers c on c.id = ord.customer_id
where (c.first_name = 'Sofia' and c.last_name = 'Sanchez')
and vegan <> 1
order by off.id;

select distinct r.id, r.name
from restaurants r
join orders o on r.id = o.restaurant_id
join offerings o2 on r.id = o2.restaurant_id
join customers c on o.customer_id = c.id
where c.regular = true
and o2.vegan = true
and o.priority = 'high'
order by r.id;

select name,
       case
           when price > 25 then 'expensive'
           when price > 10 then 'affordable'
           else 'cheap'
        end price_category
from offerings
order by price desc, name;

# 4 proc and func

create function
    udf_get_offerings_average_price_per_restaurant (restaurant_name VARCHAR(40))
returns decimal (19,2)
not deterministic
reads sql data
    return (select round(avg(price), 2)
    from restaurants r
    join offerings o on r.id = o.restaurant_id
    where r.name = restaurant_name
    group by r.id);

SELECT r.name, udf_get_offerings_average_price_per_restaurant('Burger Haven') as average_offering_price
FROM restaurants r
WHERE r.name = 'Burger Haven'

drop procedure udp_update_prices;
create procedure udp_update_prices (restaurant_type VARCHAR(40))
update offerings
set price = price + 5
where restaurant_id in (select id
                       from restaurants
                       where non_stop = true
                       and type = restaurant_type);
CALL udp_update_prices ('buffet');
select * from offerings;