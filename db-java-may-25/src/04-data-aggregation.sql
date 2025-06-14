use gringotts;

select * from wizzard_deposits;

select count(*) from wizzard_deposits;

select max(magic_wand_size) as longest_magic_wand from wizzard_deposits;

select deposit_group, max(magic_wand_size) as longest_magic_wand from wizzard_deposits
group by deposit_group
order by longest_magic_wand, deposit_group;

select deposit_group from wizzard_deposits
group by deposit_group
order by avg(magic_wand_size)
limit 1;

select deposit_group, sum(deposit_amount) as total_sum from wizzard_deposits
group by deposit_group
order by total_sum asc;

select deposit_group,
       sum(deposit_amount) as total_sum
from wizzard_deposits
where magic_wand_creator = "Ollivander family"
group by deposit_group
order by deposit_group;

select deposit_group,
       sum(deposit_amount) as total_sum
from wizzard_deposits
where magic_wand_creator = "Ollivander family"
group by deposit_group
having total_sum < 150000
order by total_sum desc;


select deposit_group, magic_wand_creator, min(deposit_charge) from wizzard_deposits
group by deposit_group, magic_wand_creator
order by magic_wand_creator, deposit_group;


select
case
    when age <= 10 then "[0-10]"
    when age <= 20 then "[11-20]"
    when age <= 30 then "[21-30]"
    when age <= 40 then "[31-40]"
    when age <= 50 then "[41-50]"
    when age <= 60 then "[51-60]"
    else "[61+]"
end as age_group,
COUNT(age) as wizard_count
from wizzard_deposits
group by age_group
order by age_group;

select distinct substring(first_name, 1, 1) as first_letter
from wizzard_deposits
where deposit_group = "Troll Chest"
order by first_letter;

select left(first_name, 1) as first_letter
from wizzard_deposits
where deposit_group = "Troll Chest"
group by  first_letter
order by first_letter;

select deposit_group,
       is_deposit_expired,
       avg(deposit_interest) as average_interest
from wizzard_deposits
where deposit_start_date > "1985-01-01"
group by deposit_group, is_deposit_expired
order by deposit_group desc, is_deposit_expired;

use soft_uni;
select department_id, min(salary) minimum_salary
from employees
where department_id in (2, 5, 7)
group by department_id
order by department_id;

create table employees_salary_over_3k as
select * from employees
where salary > 30000
and manager_id <> 42;

update employees_salary_over_3k
set salary = salary + 5000
where department_id = 1;

select department_id,
       avg(salary) avg_salary
from employees_salary_over_3k
group by department_id
order by department_id;

select department_id, max(salary) max_salary
from employees
group by department_id
having max_salary < 30000 or max_salary > 70000
order by department_id;

select count(*)
from employees
where manager_id is null;

select e1.department_id,
       (
           select distinct salary
           from employees e2
           where e1.department_id = e2.department_id
           order by salary desc
           limit 2, 1
       ) as third_highest_salary
from employees e1
group by e1.department_id
having count(distinct salary) >= 3
order by e1.department_id;

select  e1.first_name, e1.last_name, e1.department_id
from employees e1
where e1.salary > (
    select avg(e2.salary)
    from employees e2
    where e1.department_id = e2.department_id
    group by e2.department_id
    )
order by department_id, employee_id
limit 10;

select department_id,
       sum(salary)
from employees
group by department_id
order by department_id;
