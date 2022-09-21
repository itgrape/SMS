create table sms_student(
    ID number(10) not null primary key,
    NAME varchar2(20) not null,
    age number(4) check(age between 1 and 100),
    sex varchar2(5) check(sex in ('boy', 'girl')),
    score BINARY_DOUBLE,
    CLASS number(10),
    ROLE number(2) default 2 not null,
    phoneNumber varchar2(15) not null
);

create sequence t_stu
minvalue 1
nomaxvalue
increment by 1
nocache;

create or replace trigger t_stu_id_trigger
    before insert on sms_student
    for each row
begin
    select t_stu.nextval into :new.id from dual;
end t_stu_id_trigger;
    
    
    
    
insert into sms_student 
(name, age, sex, score, class, role, phoneNumber)
values
('张三', 20, 'boy', 20.0, 1, 2, '110');
    
insert into sms_student 
(name, age, sex, score, class, role, phoneNumber)
values
('李四', 15, 'boy', 60.0, 1, 2, '119');






create table sms_teacher(
    ID number(10) not null primary key,
    NAME varchar2(20) not null,
    age number(4) check(age between 1 and 100),
    sex varchar2(5) check(sex in ('man', 'woman')),
    class number(10),
    role number(2) default 1 not null,
    email varchar2(20) not null,
    password varchar2(20) not null
);


create sequence t_tea
minvalue 1
nomaxvalue
increment by 1
nocache;

create or replace trigger t_tea_id_trigger
    before insert on sms_teacher
    for each row
begin
    select t_tea.nextval into :new.id from dual;
end t_tea_id_trigger;
    
    
insert into sms_teacher
(name, role, email, password)
values
('root', 0, '123@root.com', 'root');

insert into sms_teacher
(name, age, sex, class, role, email, password)
values
('pillage', 20, 'man', 1, 1, 'pillage@qq.com', 'pillage');

commit;
