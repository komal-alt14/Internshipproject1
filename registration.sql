CREATE DATABASE cricket_academy;

USE cricket_academy;

CREATE TABLE registrations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    gender VARCHAR(10) NOT NULL,
    duration VARCHAR(50) NOT NULL,
    batch_time TIME NOT NULL,
    uniform VARCHAR(50) NOT NULL,
    parent_full_name VARCHAR(100) NOT NULL,
    mobile VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    package VARCHAR(100) NOT NUll
    );

select *from cricket_academy.registrations;
