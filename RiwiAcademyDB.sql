CREATE DATABASE RiwiAcademyDB;
USE RiwiAcademyDB;

CREATE TABLE Students (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
lastname VARCHAR(50) NOT NULL,
status ENUM('ACTIVE','INACTIVE'),
email VARCHAR(100) UNIQUE,
course_id INT NOT NULL,
FOREIGN KEY (course_id) REFERENCES Courses(id) ON DELETE CASCADE
);

CREATE TABLE Courses(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) UNIQUE
);

CREATE TABLE Registrations (
id INT AUTO_INCREMENT PRIMARY KEY,
student_id INT NOT NULL,
course_id INT NOT NULL,
FOREIGN KEY (student_id) REFERENCES Students(id) ON DELETE CASCADE,
FOREIGN KEY (course_id) REFERENCES Courses(id) ON DELETE CASCADE
);

CREATE TABLE Qualifications(
id INT AUTO_INCREMENT PRIMARY KEY,
Qualification INT NOT NULL,
description TEXT NOT NULL,
course_id INT NOT NULL,
student_id INT NOT NULL,
FOREIGN KEY (course_id) REFERENCES Courses(id) ON DELETE CASCADE,
FOREIGN KEY (student_id) REFERENCES Students(id) ON DELETE CASCADE
);

SELECT * FROM Students;
SELECT * FROM Courses;