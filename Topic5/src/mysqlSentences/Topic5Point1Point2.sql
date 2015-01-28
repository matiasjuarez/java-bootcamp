use highschool;

create table student(
firstname varchar(50) not null,
lastname varchar(50) not null,
registrationNumber int unsigned primary key,
dateOfBirth date not null
);

create table teacher(
firstname varchar(50) not null,
lastname varchar(50) not null,
dateOfBirth date,
primary key(firstname, lastname)
);

create table course(
name varchar(50) primary key,
teacherFirstName varchar(50) not null,
teacherLastName varchar(50) not null,
constraint relationCourseTeacher
foreign key FK_courseTeacherFirstNameTeacherLastName(teacherFirstName, teacherLastName)
References teacher(firstname, lastname)
);




create table coursesPerStudent(
courseName varchar(50),
registrationNumber int unsigned,
primary key(courseName, registrationNumber),
Constraint relationCoursesPerStudentCourse
foreign key FK_courseName(courseName)
references course(name),
constraint relationCoursesPerStudentStudent
foreign key FK_registrationNumber(registrationNumber)
references student(registrationNumber)
);

create table marksPerStudentPerCourse(
markId int unsigned,
mark int unsigned,
courseName varchar(50),
registrationNumber int unsigned,
primary key(courseName, registrationNumber, markId),
constraint relationMarksPerStudentPerCourseCourse
foreign key FK_marksPerStudentPerCourseCourseName(courseName)
references course(name)
);


create table courseSchema(
day varchar(15),
beginningHour date,
finishingHour date,
courseName varchar(50),
primary key(courseName, day, beginningHour),
constraint relationCourseSchemaCourse
foreign key FK_coursesSchemaCourseName(courseName)
references course(name)
);


create table coursesPerTeacher(
teacherFirstName varchar(50),
teacherLastName varchar(50),
courseName varchar(50),
primary key(teacherFirstName, teacherLastName, courseName),
constraint relationCoursesPerTeacherTeacher
foreign key FK_coursesPerTeacherTeacherFirstNameTeacherLastName(teacherFirstName, teacherLastName)
references teacher(firstname, lastname),
constraint relationCoursesPerTeacherCourse
foreign key FK_coursesPerTeacherCourseName(courseName)
references course(name)
);

