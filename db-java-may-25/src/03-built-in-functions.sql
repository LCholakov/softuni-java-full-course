use soft_uni;

select first_name, last_name from employees
where last_name like "%ei%"
order by employee_id;

select first_name from employees
where department_id in (3, 10)
and YEAR(hire_date) >= 1995 and YEAR(hire_date) <= 2005
order by employee_id;

select first_name, last_name from employees
where job_title not like "%engineer%"
order by employee_id;

select name from towns
where length(name) in (5, 6)
order by name;

select * from towns
where substr(name, 1, 1) in ("M", "K", "B", "E")
order by name;

select * from towns
where substr(name, 1, 1) not in ("R", "B", "D")
order by name;

create view v_employees_hired_after_2000 as
    select first_name, last_name from employees
where year(hire_date) > 2000;

select * from v_employees_hired_after_2000;

select first_name, last_name from employees
where length(last_name) = 5;

use geography;

select country_name, iso_code from countries
where country_name like "%a%a%a%"
order by iso_code;

select peak_name, river_name, lower(concat(peak_name, substr(river_name, 2))) as mix from peaks, rivers
where substr(peak_name, -1, 1) = substr(river_name,1,1)
order by mix;

select peak_name, river_name, lower(concat(peak_name, substr(river_name, 2))) as mix from peaks, rivers
where right(peak_name, 1) = left(river_name, 1)
order by mix;

use diablo;

select name, date_format(start, '%Y-%m-%d') from games
where year(start) between 2011 and 2012
order by start, name
limit 50;

select user_name, substring(email, locate("@", email) + 1) as email_provider
from users
order by email_provider, user_name;

select user_name, ip_address from users
where ip_address like "___.1%.%.___"
order by user_name;

select * from games;

select name as game,
case
    when hour(start) between 0 and 11 then "Morning"
    when hour(start) between 12 and 17 then "Afternoon"
    else "Evening"
end as `Part of the Day`,
case
    when duration <= 3 then "Extra Short"
    when duration <= 6 then "Short"
    when duration <= 10 then "Long"
    else "Extra Long"
end as Duration
from games;

use orders;

select * from orders;

select product_name,
        order_date,
        date_add(order_date, interval 3 day) as pay_due,
        date_add(order_date, interval 1 month) as deliver_due
from orders;