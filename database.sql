create table parameters(name char(20) primary key, description char (30), type char (30), category char(30));
create table parametersText (name char(20) primary key, value char(30), FOREIGN KEY (name) REFERENCES parameters (name));
create table parametersNumber (name char(20) primary key, value int, FOREIGN KEY (name) REFERENCES parameters (name));
create table parametersDate (name char(20) primary key, value date, FOREIGN KEY (name) REFERENCES parameters (name));

insert into parameters (name, description, type, category) values ( 'testName', 'testDescription', 'text', 'normal');
insert into parametersText (name, value) values ( 'testName','testValue');
insert into parametersNumber (name, value) values ( 'testName',123);
insert into parametersDate (name, value) values ( 'testName','2015-10-11');