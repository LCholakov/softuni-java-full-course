use soft_uni;

# 1.
select employee_id, job_title, e.address_id, address_text
from employees e
join addresses a on e.address_id = a.address_id
order by address_id
limit 5;

# 2.

select first_name, last_name, t.name town, address_text
from employees e
join addresses a on e.address_id = a.address_id
join towns t on a.town_id = t.town_id
order by first_name, last_name
limit 5;

# 3.
select employee_id, first_name, last_name, d.name department_name
from employees e
join departments d on e.department_id = d.department_id
where d.name = "Sales"
order by employee_id desc;

# 4.
select employee_id, first_name, salary, d.name department_name
from employees e
join departments d on e.department_id = d.department_id
where salary > 15000
order by d.department_id desc
limit 5;

select employee_id, first_name
from employees
where employee_id not in (
    select distinct employee_id from employees_projects
    )
order by employee_id desc
limit 3;

select * from employees_projects;

# 6.
select first_name, last_name, hire_date, d.name dept_name
from employees e
join departments d on e.department_id = d.department_id
where hire_date > "1999-01-01"
and d.name in ("Sales", "Finance")
order by hire_date;

# 7.
select e.employee_id, first_name, p.name project_name
from employees e
join employees_projects ep on e.employee_id = ep.employee_id
join projects p on ep.project_id = p.project_id
where date(p.start_date) > '2002-08-13'
and p.end_date is null
order by first_name, p.name
limit 5;

# 8.
select e.employee_id, first_name, if(year(p.start_date) >= 2005, NULL, p.name) project_name
from employees e
join employees_projects ep on e.employee_id = ep.employee_id
join projects p on ep.project_id = p.project_id
where e.employee_id = 24
order by p.name;

# 9.
select e1.employee_id, e1.first_name, e1.manager_id, e2.first_name manager_name
from employees e1
join employees e2 on e1.manager_id = e2.employee_id
where e1.manager_id in (3, 7)
order by e1.first_name;

# 10.
select e1.employee_id,
       concat(e1.first_name, ' ', e1.last_name) employee_name,
       concat(e2.first_name, ' ', e2.last_name) manager_name,
       d.name department_name
from employees e1
join employees e2 on e1.manager_id = e2.employee_id
join departments d on e1.department_id = d.department_id
order by e1.employee_id
limit 5;

# 11.
select avg(salary) min_average_salary
from employees
group by department_id
order by min_average_salary
limit 1;

use geography;

# 12.
select country_code, mountain_range, peak_name, elevation
from mountains m
join mountains_countries mc on m.id = mc.mountain_id
join peaks p on m.id = p.mountain_id
where country_code = 'BG'
and elevation > 2835
order by elevation desc;

# 13.
select country_code, count(mountain_range) mountain_range
from mountains m
join mountains_countries mc on m.id = mc.mountain_id
where country_code in ('BG', 'RU', 'US')
group by country_code
order by mountain_range desc;

# 14.
select country_name, river_name
from countries c
left join countries_rivers cr on c.country_code = cr.country_code
left join rivers r on cr.river_id = r.id
where continent_code = 'AF'
order by country_name
limit 5;

# 15.

select t1.continent_code, t1.currency_code, t1.currency_usage
from (select continent_code, currency_code, count(*) currency_usage
      from countries
      group by continent_code, currency_code
      having currency_usage > 1
      order by continent_code, currency_code) t1
join (
    select continent_code, max(currency_usage) currency_usage
    from (select continent_code, currency_code, count(*) currency_usage
      from countries
      group by continent_code, currency_code
      having currency_usage > 1
      order by continent_code, currency_code) t2
    group by continent_code
) t3 on t1.continent_code = t3.continent_code
and t1.currency_usage = t3.currency_usage
order by continent_code, currency_code;

select count(*)
from countries c
left join mountains_countries mc on c.country_code = mc.country_code
where mountain_id is null;

select country_name, max(p.elevation) highest_peak_elevation, max(r.length) longest_river_length
from countries c
join mountains_countries mc on c.country_code = mc.country_code
join mountains m on mc.mountain_id = m.id
join peaks p on m.id = p.mountain_id
join countries_rivers cr on c.country_code = cr.country_code
join rivers r on cr.river_id = r.id
group by country_name
order by highest_peak_elevation desc,
         longest_river_length desc,
         country_name
limit 5;

select * from rivers;