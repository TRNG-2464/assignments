create table Principles(
    name varchar(255) primary key,
    hire_date date not null,
    salary decimal(10, 2) not null
);
create table Schools(
    name varchar(255) primary key,
    principle_name varchar(255) not null references Principles (name)
);
create table Students(
    name varchar(255) primary key,
    grade_level int not null,
    home_address varchar(255) not null,
    emergency_contact_phone_number varchar(255) not null,
    school_name varchar(255) not null references Schools(name)
);