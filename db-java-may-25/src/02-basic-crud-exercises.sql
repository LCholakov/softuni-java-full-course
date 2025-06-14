drop schema soft_uni;

SELECT VERSION();

SHOW VARIABLES LIKE 'version';

use soft_uni;

select name from departments;

select first_name, middle_name, last_name from employees;

select concat(first_name, ".", last_name, "@softuni.bg ") as full_email_address
from employees;

select distinct salary from employees order by salary;

select * from employees
where job_title = "Sales Representative";

select first_name, last_name, job_title from employees
where salary >= 20000 and salary <= 30000
order by employee_id;

select concat(first_name, " ", middle_name, " ", last_name) as "Full Name"
from employees
where salary in (25000, 14000, 12500, 23600);

select first_name, last_name from employees where manager_id is null;

select first_name, last_name, salary from employees
where salary > 50000
order by salary desc;

select first_name, last_name from employees
order by salary desc
limit 5;

select first_name, last_name from employees
where department_id <> 4;

select * from employees
order by salary desc, first_name, last_name desc, middle_name, employee_id;

create view v_employees_salaries as
select first_name, last_name, salary from employees;

create view v_employees_job_titles as
    select concat(first_name, " ",
                   IFNULL(CONCAT(middle_name, ' '), ''),
                  last_name) as full_name,
           job_title
    from employees;

select distinct job_title from employees
order by job_title;

select * from projects
order by start_date, name, project_id
limit 10;

select first_name, last_name, hire_date from employees
order by  hire_date desc
limit 7;

select * from departments;

UPDATE employees
set salary = salary * 1.12
where department_id in (1, 2, 4, 11);

select salary from employees;

use geography;

select peak_name from peaks
order by peak_name;

select * from continents;

select country_name, population from countries
where continent_code = 'EU'
order by population desc, country_name
limit 30;

select * from countries;

select country_name, country_code, if(currency_code = "EUR", 'Euro', "Not Euro") as currency from countries
order by country_name;

use diablo;

select name from characters order by name;

