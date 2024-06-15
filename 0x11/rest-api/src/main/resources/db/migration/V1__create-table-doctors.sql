create table doctors(
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    identification varchar(10) not null unique,
    specialization varchar(100) not null,
    country varchar(100) not null,
    city varchar(100) not null,
    complement varchar(100),
    primary key(id)
)