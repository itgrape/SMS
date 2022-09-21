CREATE DATABASE sms DEFAULT CHARACTER SET UTF8;

USE sms;


DROP TABLE if EXISTS sms_student;
create table sms_student(
    id INT(10) not null AUTO_INCREMENT,
    name VARCHAR(20) not null,
    age INT(4) check(age between 1 and 100),
    sex VARCHAR(5) check(sex in ('boy', 'girl')),
    score DOUBLE,
    CLASS INT(10),
    ROLE INT(2) default 2 not null,
    phoneNumber VARCHAR(15) not null,
		PRIMARY KEY (id)
) ENGINE=INNODB AUTO_INCREMENT=122 DEFAULT CHARSET=UTF8;

    
insert into sms_student 
(name, age, sex, score, class, role, phoneNumber)
values
('张三', 20, 'boy', 20.0, 1, 2, '110');
    
insert into sms_student 
(name, age, sex, score, class, role, phoneNumber)
values
('李四', 15, 'boy', 60.0, 1, 2, '119');





DROP TABLE if EXISTS sms_teacher;
create TABLE sms_teacher(
    id INT(10) not null AUTO_INCREMENT,
    name VARCHAR(20) not null,
    age INT(4) check(age between 1 and 100),
    sex VARCHAR(5) check(sex in ('man', 'woman')),
    class INT(10),
    role INT(2) default 1 not null,
    email VARCHAR(20) not null,
    password VARCHAR(20) not null,
		PRIMARY KEY (id)
) ENGINE=INNODB AUTO_INCREMENT=122 DEFAULT CHARSET=UTF8;
    
    
insert into sms_teacher
(id, name, role, email, password)
values
(1, 'root', 0, '123@root.com', 'root');

insert into sms_teacher
(name, age, sex, class, role, email, password)
values
('pillage', 20, 'man', 1, 1, 'pillage@qq.com', 'pillage');

commit;
