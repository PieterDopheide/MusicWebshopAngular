create table products(
	id int unsigned auto_increment not null UNIQUE,
	name varchar(32) not null UNIQUE,
	snippet varchar(100),
	price int(11),
	stock int(11),
	category varchar(32),
	primary key (id)
);