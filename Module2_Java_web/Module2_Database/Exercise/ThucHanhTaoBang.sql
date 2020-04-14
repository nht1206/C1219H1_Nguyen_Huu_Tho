create database library;
use library;
drop table if exists students;
create table students(
	student_id int not null,
    student_name  varchar(50),
    student_birthday date,
    student_address varchar(50),
    student_email varchar(50),
    student_phonenumber varchar(15),
    primary key (student_id)
);

drop table if exists booktype;
create table booktype(
	type_id int,
    type_name varchar(25),
    primary key (type_id)
);
drop table if exists author;
create table author(
	author_id int,
    author_name varchar(50),
    author_address varchar(50),
    primary key (author_id)
);

drop table if exists publishing;
create table publishing(
	publishing_id int,
    publishing_name varchar(50),
    primary key (publishing_id)
);

create table books (
	book_id int ,
    book_name varchar(50),
    publishing_year varchar(4),
    quanity int,
    type_id int,
    author_id int,
    publishing_id int,
    primary key (book_id),
    foreign key (type_id) references booktype(type_id),
    foreign key (author_id) references author(author_id),
    foreign key (publishing_id) references publishing(publishing_id)
);
-- data for table books
insert into books(book_id,book_name,publishing_year,quanity,type_id,author_id,publishing_id) value
(01,'Chia khoa vu tru George','2007',2,001,01,01),
(02,'Ke giau mat ngoai hanh tinh','2009',1,001,01,01),
(03,'George va vu no Big Bang','2016',2,001,01,01),
(04,'Nguoi ve tu sao hoa','2015',2,001,02,02),
(05,'Artemis','2017',1,001,02,01),
(06,'Nhung nguoi khon kho','1962',5,002,03,01),
(07,'Ngay cuoi cung cua mot tu tu','1970',5,002,03,01),
(08,'Lao dong va bien ca','1969',4,002,03,01),
(09,'Nha gia Kim','1988',9,002,04,01),
(10,'An gi khong chet','2018',3,003,05,03),
(11,'Ngu it van khoe','2017',3,003,06,03),
(12,'Nghe thuat truyen cam hung','2018',5,004,07,04),
(13,'Dan nhap vao nghe thuat','2019',3,004,08,03),
(14,'Luoc su loai nguoi','2019',10,005,09,05),
(15,'Luoc su tuong lai','2019',5,005,09,06),
(16,'Cau chuyen giai tich','2018',5,006,10,06),
(17,'Cau chuyen dai so','2018',5,006,10,03);
select * from books;
drop table if exists rent;
create table rent(
	rent_id int,
	rent_date date,
    pay_date date,
    number_date int not null,
    student_id int,
    book_id int,
    primary key (rent_id),
    foreign key (student_id) references students(student_id),
    foreign key (book_id) references books(book_id)
);
-- data for table rent
insert into rent(rent_id,rent_date,pay_date,number_date,student_id,book_id) value
(1,'2020-03-16','2020-03-18',3,1,01),
(2,'2020-03-18','2020-03-21',4,3,05);

insert into students(student_id,student_name,student_birthday,student_address,student_email,student_phonenumber) value
(1,'Nguyen Thi Dieu My','1997-09-09','Quang Nam','my@gmail.com','0123456789'),
(2,'Nguyen Huu Tho','1999-12-06','Quang Tri','tho@gmail.com','1234567890'),
(3,'Tran Van Thuan','1999-01-01','Da Nang','thuan@gmail.com','2345678901'),
(4,'Nguyen Ha Nguyen','1998-01-01','Da Nang','nguyen@gmail,com','3456789012'),
(5,'Phan Thi My Tinh','1995-08-01','Da Nang','tinh@gmail.com','4567890123');
select * from students;
-- data for table booktype
insert into booktype(type_id,type_name) value
(001,'Khoa hoc'),
(002,'Van Hoc'),
(003,'Y Hoc'),
(004,'Nghe Thuat'),
(005,'Lich Su'),
(006,'Toan Hoc');
select * from booktype;
-- data for table author
insert into author(author_id,author_name,author_address) value
(01,'Stephen Hawking','England'),
(02,'Andy Weir','USA'),
(03,'Victor Hugo','France'),
(04,'Paulo Coelho','Brazil'),
(05,'Michael Greger','USA'),
(06,'Satoru Tsubota','USA'),
(07,'Benjamin Loh','England'),
(08,'Laurie Scheneider','USA'),
(09,'Yuval Noah Harari','Israel'),
(10,'Larry Gonick','USA');
select * from author;
-- data for table publishing
insert into publishing(publishing_id,publishing_name) value
(01,'NXB Van Hoc'),
(02,'NXB NXB Kim Dong'),
(03,'NXB Tre'),
(04,'NXB Thanh Nien'),
(05, 'NXB Tri Thuc'),
(06,'NXB The Gioi');
drop table if exists books;

