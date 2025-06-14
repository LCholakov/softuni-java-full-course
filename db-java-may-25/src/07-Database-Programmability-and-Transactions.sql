use soft_uni;
# 1.
create procedure usp_get_employees_salary_above_35000()
    select first_name, last_name
    from employees
    where salary > 35000
    order by first_name, last_name, employee_id;

# 2.
create procedure usp_get_employees_salary_above(s decimal(20,4))
    select first_name, last_name
    from employees
    where salary >= s
    order by first_name, last_name, employee_id;

call usp_get_employees_salary_above(100000);

# 3.
drop procedure usp_get_towns_starting_with;
create procedure usp_get_towns_starting_with (s varchar(10))
select name as town_name
from towns
where name like concat(s, '%')
order by town_name;

call usp_get_towns_starting_with('b')

# 4.
drop procedure usp_get_employees_from_town;
create procedure usp_get_employees_from_town(town_name varchar(20))
select first_name, last_name
from employees e
join addresses a on e.address_id = a.address_id
join towns t on a.town_id = t.town_id
where t.name = town_name
order by first_name, last_name, employee_id;

call usp_get_employees_from_town('Sofia')

# 5.

create function ufn_get_salary_level(salary decimal(20, 4))
returns varchar(8)
deterministic
begin
    return case
        when salary < 30000 then 'Low'
        when salary <= 50000 then 'Average'
        else 'High'
    end;
end;

select ufn_get_salary_level(10000)

# 6.
create procedure usp_get_employees_by_salary_level (salary_level varchar(8))
select first_name, last_name
from employees
where ufn_get_salary_level(salary) = salary_level
order by first_name desc, last_name desc;

call usp_get_employees_by_salary_level('high')

# 7.
drop function ufn_is_word_comprised
create function ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
returns int
deterministic
begin
    declare i int default 1;
    declare c char(1);
    while i <= length(word) do
        set c = substring(word, i, 1);
        if locate(c, set_of_letters) = 0
            then return 0;
        end if;
        set i = i + 1;
    end while;
    return 1;
end;

# 8.
create procedure usp_get_holders_full_name()
select concat(first_name, ' ', last_name) full_name
from account_holders
order by full_name, id;

# 9.
create procedure usp_get_holders_with_balance_higher_than(total decimal(20,4))
select first_name, last_name
from account_holders ah
join accounts a on ah.id = a.account_holder_id
group by first_name, last_name
having sum(a.balance) > total;

# 10.
create function ufn_calculate_future_value(
    amount decimal(20, 4),
    interest_rate double(20,4),
    years int)
returns decimal(20, 4)
deterministic
begin
    return amount * (pow((1+interest_rate),years));
end;

# 11.
create procedure usp_calculate_future_value_for_account (
    account_id int,
    interest_rate double(20,4))
select a.id account_id,
       ah.first_name,
       ah.last_name,
       a.balance current_balance,
       ufn_calculate_future_value(balance, interest_rate, 5) balance_in_5_years
from account_holders ah
join accounts a on a.account_holder_id = ah.id
where a.id = account_id;

# 12.
create procedure usp_deposit_money(
    account_id int,
    money_amount decimal (20, 4))
    if money_amount > 0 then
update accounts
    set balance = balance + money_amount
        where id = account_id;
    end if;

select * from accounts;

# 13.
create procedure usp_withdraw_money(
    account_id int,
    money_amount decimal (20, 4))
    begin
        declare curr_balance decimal (20, 4);
        select balance
            into curr_balance
            from accounts a
        where id = account_id;
        if money_amount > 0
               and  curr_balance - money_amount > 0 then
            update accounts
                set balance = balance - money_amount
            where id = account_id;
        end if;
    end;

# 14.
create procedure usp_transfer_money(
    from_account_id int,
    to_account_id int,
    amount decimal (20, 4))
    begin
        start transaction;
        if (select count(*) from accounts where id = from_account_id) != 1
            or (select count(*) from accounts where id = to_account_id) != 1
            or from_account_id = to_account_id
            or amount <= 0
            or (select balance from accounts where id = from_account_id) - amount < 0
                then rollback;
        else
            update accounts
                set balance = balance - amount
            where id = from_account_id;
            update accounts
                set balance = balance + amount
            where id = to_account_id;

            commit;
        end if;
    end;

# 15.
create table logs(
    log_id int primary key auto_increment,
    account_id int,
    old_sum decimal(20, 4),
    new_sum decimal(20, 4)
);

create trigger trg_account_changes
    after update on accounts
    for each row
    begin
        if old.balance != new.balance
            then insert into logs (account_id, old_sum, new_sum)
                values (new.id, old.balance, new.balance);
        end if;
    end;

# 16.
create table notification_emails(
    id int primary key auto_increment,
    recipient varchar(60),
    subject varchar(200),
    body varchar(10000));

create trigger trg_new_log
    after insert on logs
    for each row
    begin
        insert into notification_emails (recipient, subject, body)
            values (new.account_id,
                    concat('Balance change for account: ', new.account_id),
                    concat('On ',
                           DATE_FORMAT(NOW(),'%b %e %Y at %l:%i:%s %p'),
                           ' your balance was changed from ',
                           new.old_sum,
                           ' to ',
                           new.new_sum));
    end;


select * from logs;
select * from notification_emails;
select * from accounts limit 1;
update accounts
# set balance = 133.1200
set balance = 0
where id = 1;