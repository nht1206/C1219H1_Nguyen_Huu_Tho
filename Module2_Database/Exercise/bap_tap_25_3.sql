create database baitap_25_03;
use  baitap_25_03;

create table categories (
	id int(11) primary key,
    name varchar(50) not null,
    description varchar(500)
);
create table suppliers (
	id int(11) primary key,
    name varchar(100) not null,
    email varchar(50) not null,
    phone_number varchar(20),
    address varchar(500)
);

create table employees (
	id int(11) primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    phone_number varchar(20),
    address varchar(500) not null,
    email varchar(50) not null,
    birthday datetime
);

create table customers(
	id int(11) primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    phone_number varchar(20),
    address varchar(500) not null,
    email varchar(50) not null,
    birthday datetime
);

create table products(
	id int(11) primary key,
    name varchar(50) not null,
    image_uri varchar(1000) not null,
    price decimal(18,2),
    discount decimal(18,2),
    stock decimal(18,2),
    category_id int (11),
    supplier_id int(11),
    description varchar(1000),
    constraint fk_category_id foreign key (category_id) references categories(id),
    constraint fk_suppiler_id foreign key (supplier_id) references suppliers(id)
);


create table orders(
	id int(11) primary key,
    created_date datetime not null,
    shipped_date datetime,
    status varchar(50) not null,
    description varchar(1000),
    shipping_address varchar(50) not null,
    shipping_ctiy varchar(20) not null,
    payment_type varchar(20) not null,
    customer_id int(11),
    employee_id int(11),
    constraint fk_customer_id foreign key (customer_id) references customers(id),
    constraint fk_employee_id foreign key (employee_id) references employees(id)
);

create table order_details(
	id int(11) primary key,
    order_id int(11),
    product_id int(11),
    quantity decimal(18,2),
    constraint fk_order_id foreign key (order_id) references orders(id),
    constraint fk_product_id foreign key (product_id) references products(id)
);
