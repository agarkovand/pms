DROP TABLE it_company_project;
DROP TABLE project_developer;
DROP TABLE developer_skill;
DROP TABLE developer_it_company;
DROP TABLE project;
DROP TABLE it_company;
DROP TABLE customer;
DROP TABLE skill;
DROP TABLE developer;

--  it_company

CREATE TABLE it_company
(
 id           INT NOT NULL AUTO_INCREMENT,
 name         VARCHAR(45) NOT NULL,
 zip_code     VARCHAR(5),
 city         VARCHAR(45),
 address_line VARCHAR(45),
 country      VARCHAR(45),

PRIMARY KEY (id)
);

--  customer

CREATE TABLE customer
(
 id      INT NOT NULL AUTO_INCREMENT,
 name    VARCHAR(45) NOT NULL,
 country VARCHAR(45),
 city    VARCHAR(45),

PRIMARY KEY (id)
);

--  skill

CREATE TABLE skill
(
 id                INT NOT NULL AUTO_INCREMENT,
 area_of_expertise VARCHAR(45) NOT NULL,
 mastery_level     VARCHAR(15) NOT NULL,

PRIMARY KEY (id)
);

--  developer

CREATE TABLE developer
(
 id             INT NOT NULL AUTO_INCREMENT,
 first_name     VARCHAR(45) NOT NULL,
 last_name      VARCHAR(45) NOT NULL,
 date_of_birth  DATE,
 country        VARCHAR(45),
 city           VARCHAR(45),
 gender         CHAR(1),
 marital_status VARCHAR(20),

PRIMARY KEY (id)
);

--  developer_skill

CREATE TABLE developer_skill
(
 skill_id       INT NOT NULL,
 developer_id   INT NOT NULL,
 effective_from DATE NOT NULL,

PRIMARY KEY (skill_id, developer_id),
FOREIGN KEY dev_skill_skill_id_fk (skill_id) REFERENCES skill (id),
FOREIGN KEY dev_skill_dev_id_fk (developer_id) REFERENCES developer (id)
);

--  developer_it_company

CREATE TABLE developer_it_company
(
 developer_id   INT NOT NULL,
 it_company_id  INT NOT NULL,
 start_date     DATE NOT NULL,
 monthly_salary DECIMAL NOT NULL,
 end_date       DATE,

PRIMARY KEY (developer_id, it_company_id, start_date),
FOREIGN KEY dev_it_comp_dev_id_fk (developer_id) REFERENCES developer (id),
FOREIGN KEY dev_it_comp_comp_id_fk (it_company_id) REFERENCES it_company (id)
);

--  project

CREATE TABLE project
(
 id             INT NOT NULL AUTO_INCREMENT,
 customer_id    INT NOT NULL,
 title          VARCHAR(45) NOT NULL,
 project_start  DATE,
 planned_finish DATE,
 actual_finish  DATE,

PRIMARY KEY (id),
FOREIGN KEY project_cust_id_fk (customer_id) REFERENCES customer (id)
);

--  it_company_project

CREATE TABLE it_company_project
(
 project_id     INT NOT NULL,
 it_company_id  INT NOT NULL,
 start_date     DATE NOT NULL,
 monthly_budget DECIMAL NOT NULL,
 end_date       DATE,

PRIMARY KEY (project_id, it_company_id, start_date),
FOREIGN KEY it_comp_pr_pr_id_fk (project_id) REFERENCES project (id),
FOREIGN KEY it_comp_pr_it_comp_id_fk (it_company_id) REFERENCES it_company (id)
);

--  project_developer

CREATE TABLE project_developer
(
 project_id     INT NOT NULL,
 developer_id   INT NOT NULL,
 start_date     DATE NOT NULL,
 hours_per_week INT NOT NULL,
 end_date       DATE,

PRIMARY KEY (project_id, developer_id,  start_date),
FOREIGN KEY pr_dev_pr_id (project_id) REFERENCES project (id),
FOREIGN KEY pr_dev_dev_id (developer_id) REFERENCES developer (id)
);
