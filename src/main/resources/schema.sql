create table complaint
(
   id integer not null,
   name varchar(255) not null, 
   category varchar(255) not null,
   description varchar(255) not null,
   status varchar(50),
   action varchar(255),
   primary key(id)
);