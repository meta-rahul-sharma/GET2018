CREATE DATABASE employee_portal;

USE employee_portal;

CREATE TABLE Employee (
    emp_code VARCHAR(15),
    first_name VARCHAR(25) NOT NULL,
    middle_name  VARCHAR(25),
    last_name VARCHAR(25),#not mentioned
    dob DATE NOT NULL,
    gender CHAR(1) NOT NULL,
    primary_contact_no CHAR(10),
    secondary_contact_no CHAR(10),
    email VARCHAR(100) NOT NULL,
    skype_id VARCHAR(50),
    profile_picture VARCHAR(70),
    password VARCHAR(20) DEFAULT "123456",
    enabled BOOLEAN DEFAULT TRUE,
    CONSTRAINT PK_Employee PRIMARY KEY (emp_code)
);

CREATE TABLE Job_Title(
    job_code INTEGER AUTO_INCREMENT,
    job_title VARCHAR(50) NOT NULL,
    CONSTRAINT PK_Job_Title PRIMARY KEY(job_code)
);

CREATE TABLE UserRoles(
    user_role_id INTEGER AUTO_INCREMENT NOT NULL,
    username VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    CONSTRAINT PK_UserRoles PRIMARY KEY(user_role_id)
);

CREATE TABLE Skills(
    skill_id INTEGER AUTO_INCREMENT,
    skill_name VARCHAR(50) NOT NULL,
    CONSTRAINT PK_Skills PRIMARY KEY (skill_id)
);

CREATE TABLE Employee_Skills(
    emp_skill_id INTEGER AUTO_INCREMENT,
    emp_code VARCHAR(15) NOT NULL, 
    skill_code INTEGER NOT NULL,
    CONSTRAINT PK_Employee_Skills PRIMARY KEY (emp_skill_id),
    CONSTRAINT FK_Employee_SkillsEmployee_emp_code FOREIGN KEY (emp_code) REFERENCES Employee (emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_Employee_SkillsUserRoles_skill_code FOREIGN KEY (skill_code) REFERENCES Skills (skill_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Project(
    project_id INTEGER AUTO_INCREMENT,
    description VARCHAR(250) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    name VARCHAR(70),
    CONSTRAINT PK_Project PRIMARY KEY (project_id)
);

CREATE TABLE Address(
    address_id INTEGER AUTO_INCREMENT,
    emp_code VARCHAR(15) NOT NULL,#was int in assignment
    add_line_1 VARCHAR(100) NOT NULL,
    add_line_2 VARCHAR(100),
    city VARCHAR(25) NOT NULL,
    state VARCHAR(25) NOT NULL,
    pincode CHAR(6) NOT NULL,#6 digit pincodes
    CONSTRAINT PK_Address PRIMARY KEY (address_id),
    CONSTRAINT FK_AddressEmployee_emp_code FOREIGN KEY (emp_code) REFERENCES Employee(emp_code) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Job_Details(    
    job_detail_id INTEGER AUTO_INCREMENT,
    emp_code VARCHAR(15),#was int in assignment
    date_of_joining DATE NOT NULL,
    total_exp DOUBLE,
    job_code INTEGER,#was string in assignment
    reporting_mgr VARCHAR(15),#was int in assignment
    team_lead VARCHAR(15),#was int in assignment
    curr_proj_id INTEGER,
    CONSTRAINT PK_Job_Details PRIMARY KEY (job_detail_id),
    CONSTRAINT FK_Job_DetailsEmployee_emp_code FOREIGN KEY (emp_code) REFERENCES Employee (emp_code),    
    CONSTRAINT FK_Job_DetailsEmployee_reporting_mgr FOREIGN KEY (reporting_mgr) REFERENCES Employee(emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_Job_DetailsEmployee_team_lead FOREIGN KEY (team_lead) REFERENCES Employee(emp_code) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_Job_DetailsJob_Title_job_code FOREIGN KEY (job_code) REFERENCES Job_Title(job_code) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_Job_DetailsProject_project_id FOREIGN KEY (curr_proj_id) REFERENCES Project(project_id) ON UPDATE CASCADE ON DELETE CASCADE
);

