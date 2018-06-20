-- customer
INSERT INTO customer (name, country, city) VALUES ('Cust1','Ukraine','Kiev');
INSERT INTO customer (name, country, city) VALUES ('Cust2','Ukraine','Kharkov');

-- project
INSERT INTO project (customer_id, title) VALUES ('1','Pr1');
INSERT INTO project (customer_id, title) VALUES ('1','Pr2');
INSERT INTO project (customer_id, title) VALUES ('1','Pr3');
INSERT INTO project (customer_id, title) VALUES ('2','Pr4');
INSERT INTO project (customer_id, title) VALUES ('2','Pr5');


-- it_company
INSERT INTO it_company(name) VALUES ('ItComp1');
INSERT INTO it_company(name) VALUES ('ItComp2');
INSERT INTO it_company(name) VALUES ('ItComp3');

UPDATE it_company
SET city='Kiev', country='Ukraine'
WHERE id IN (1,2);

UPDATE it_company
SET city='Kharkov', country='Ukraine'
WHERE id=3;

-- it_company_project
-- Pr1/ItComp1
-- Pr2/ItComp3
-- Pr3/ItComp2
-- Pr4/ItComp3
-- Pr5/ItComp2
-- Pr5/ItComp3

--
-- Pr1/ItComp1
INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (1,1,50000,'2016-01-01','2016-04-30');

INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (1,1,150000,'2016-05-01','2016-12-31');

INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (1,1,20000,'2017-01-01', NULL);

-- Pr2ItComp3
INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (2,3,500000,'2015-01-01','2016-06-30');

INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (2,3,750000,'2016-07-01','2017-12-31');

INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (2,3,200000,'2018-01-01', NULL);

-- Pr3/ItComp2
INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (3,2,10000,'2015-01-01','2016-06-30');

INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (3,2,40000,'2016-07-01','2017-12-31');

INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (3,2,20000,'2018-01-01', NULL);

-- Pr4/ItComp3
INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (4,3,25000,'2016-01-01','2016-09-30');

INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (4,3,45000,'2016-10-01','2017-12-31');

INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (4,3,75000,'2018-01-01', NULL);

-- Pr5/ItComp2
INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (5,2,39000,'2016-04-01','2016-04-30');

INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (5,2,78500,'2016-05-01','2017-10-31');

INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (5,2,105000,'2017-11-01', NULL);

-- Pr5/ItComp3
INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (5,3,11000,'2016-04-01','2016-04-30');

INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (5,3,15000,'2016-05-01','2017-10-31');

INSERT INTO 
it_company_project (project_id,
                    it_company_id,
                    monthly_budget,
                    start_date,
                    end_date)
VALUES (5,3,25000,'2017-11-01', NULL);


-- developer
INSERT INTO developer (first_name, last_name)
VALUES ('Dev1_FName','Dev1_LName');
INSERT INTO developer (first_name, last_name)
VALUES ('Dev2_FName','Dev2_LName');
INSERT INTO developer (first_name, last_name)
VALUES ('Dev3_FName','Dev3_LName');
INSERT INTO developer (first_name, last_name)
VALUES ('Dev4_FName','Dev4_LName');
INSERT INTO developer (first_name, last_name)
VALUES ('Dev5_FName','Dev5_LName');
INSERT INTO developer (first_name, last_name)
VALUES ('Dev6_FName','Dev6_LName');
INSERT INTO developer (first_name, last_name)
VALUES ('Dev7_FName','Dev7_LName');
INSERT INTO developer (first_name, last_name)
VALUES ('Dev8_FName','Dev8_LName');
INSERT INTO developer (first_name, last_name)
VALUES ('Dev9_FName','Dev9_LName');

-- developer_it_company
-- Dev1, ItComp1
-- Dev2, ItComp1
-- Dev3, ItComp1
-- Dev4, ItComp2
-- Dev5, ItComp2
-- Dev6, ItComp2
-- Dev7, ItComp3
-- Dev8, ItComp3
-- Dev9, ItComp3

-- Dev1, ItComp1
INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (1,1,'2015-01-01',1000,'2015-12-31');                      

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (1,1,'2016-01-01',1100,'2016-12-31');  

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (1,1,'2017-01-01',1500,'2017-12-31');

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (1,1,'2018-01-01',1800,NULL);

-- Dev2, ItComp1
INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (2,1,'2015-01-01',2000,'2015-12-31');                      

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (2,1,'2016-01-01',2200,'2016-12-31');  

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (2,1,'2017-01-01',2500,'2017-12-31');

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (2,1,'2018-01-01',2800,NULL);

-- Dev3, ItComp1
INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (3,1,'2015-01-01',1500,'2015-12-31');                      

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (3,1,'2016-01-01',1600,'2016-12-31');  

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (3,1,'2017-01-01',1800,'2017-12-31');

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (3,1,'2018-01-01',2000,NULL);

-- Dev4, ItComp2
INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (4,2,'2015-01-01',2800,'2015-12-31');                      

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (4,2,'2016-01-01',3000,'2016-12-31');  

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (4,2,'2017-01-01',3500,'2017-12-31');

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (4,2,'2018-01-01',3800,NULL);

-- Dev5, ItComp2
INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (5,2,'2015-01-01',2700,'2016-12-31');                      

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (5,2,'2017-01-01',2800,'2017-12-31');

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (5,2,'2018-01-01',3100,NULL);

-- Dev6, ItComp2
INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (6,2,'2015-01-01',800,'2015-12-31');                      

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (6,2,'2016-01-01',1000,'2016-12-31');  

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (6,2,'2017-01-01',1500,'2017-12-31');

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (6,2,'2018-01-01',1800,NULL);

-- Dev7, ItComp3
INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (7,3,'2015-01-01',900,'2015-12-31');                      

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (7,3,'2016-01-01',1000,'2016-12-31');  

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (7,3,'2017-01-01',1500,'2017-12-31');

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (7,3,'2018-01-01',2000,NULL);

-- Dev8, ItComp3
INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (8,3,'2015-01-01',2800,'2015-12-31');                      

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (8,3,'2016-01-01',3000,'2016-12-31');  

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (8,3,'2017-01-01',3500,'2017-12-31');

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (8,3,'2018-01-01',3800,NULL);

-- Dev9, ItComp3
INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (9,3,'2015-01-01',2600,'2015-12-31');                      

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (9,3,'2016-01-01',2700,'2016-12-31');  

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (9,3,'2017-01-01',2900,'2017-12-31');

INSERT INTO
developer_it_company (developer_id,
                      it_company_id,
                      start_date,
                      monthly_salary,
                      end_date)
VALUES (9,3,'2018-01-01',3100,NULL);



-- project_developer

-- pr1,dev1
INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (1,1,'2015-01-01',40,NULL);

-- pr1,dev2
INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (1,2,'2015-01-01',40,NULL);

-- pr1,dev3
INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (1,3,'2015-01-01',40,NULL);

-- dev7 - pr2,pr4 - Part time work on 2 projects
-- pr2, dev7
INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (2,7,'2015-01-01',30,'2016-04-30');

INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (2,7,'2016-05-01',25,NULL);

-- pr4, dev7
INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (4,7,'2015-01-01',10,'2016-04-30');

INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (4,7,'2016-05-01',15,NULL);

-- dev8 - pr2,pr4 - Part time work on 2 projects
-- pr2, dev8
INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (2,8,'2015-01-01',30,'2016-04-30');

INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (2,8,'2016-05-01',25,NULL);

-- pr4, dev8
INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (4,8,'2015-01-01',10,'2016-04-30');

INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (4,8,'2016-05-01',15,NULL);

-- pr3,dev4
INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (3,4,'2015-01-01',40,NULL);

-- pr5,dev6
INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (5,6,'2015-01-01',40,NULL);

-- dev5 - pr3,pr5 - Part time work on 2 projects
-- pr3, dev5
INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (3,5,'2015-01-01',10,'2016-04-30');

INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (3,5,'2016-05-01',15,NULL);

-- pr5, dev5
INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (5,5,'2015-01-01',30,'2016-04-30');

INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (5,5,'2016-05-01',25,NULL);

-- pr5,dev9
INSERT INTO
project_developer (project_id,
                   developer_id,
                   start_date,
                   hours_per_week,
                   end_date)
VALUES (5,9,'2015-01-01',40,NULL);

-- skill

-- Java
INSERT INTO skill (area_of_expertise, mastery_level)
VALUES ('Java','Junior');
INSERT INTO skill (area_of_expertise, mastery_level)
VALUES ('Java','Regular');
INSERT INTO skill (area_of_expertise, mastery_level)
VALUES ('Java','Senior');

-- C#
INSERT INTO skill (area_of_expertise, mastery_level)
VALUES ('C#','Junior');
INSERT INTO skill (area_of_expertise, mastery_level)
VALUES ('C#','Regular');
INSERT INTO skill (area_of_expertise, mastery_level)
VALUES ('C#','Senior');

-- QA
INSERT INTO skill (area_of_expertise, mastery_level)
VALUES ('QA','Junior');
INSERT INTO skill (area_of_expertise, mastery_level)
VALUES ('QA','Regular');
INSERT INTO skill (area_of_expertise, mastery_level)
VALUES ('QA','Senior');

-- developer_skill

-- dev1, JR
INSERT INTO developer_skill (skill_id, developer_id, effective_from)
VALUES (2,1,'2015-01-01');

-- dev2, JS
INSERT INTO developer_skill (skill_id, developer_id, effective_from)
VALUES (3,2,'2015-01-01');

-- dev3, QAS
INSERT INTO developer_skill (skill_id, developer_id, effective_from)
VALUES (9,3,'2015-01-01');

-- dev4, JS
INSERT INTO developer_skill (skill_id, developer_id, effective_from)
VALUES (3,4,'2015-01-01');

-- dev5, JS
INSERT INTO developer_skill (skill_id, developer_id, effective_from)
VALUES (3,5,'2015-01-01');

-- dev6, JJ
INSERT INTO developer_skill (skill_id, developer_id, effective_from)
VALUES (1,6,'2015-01-01');

-- dev7, QAR
INSERT INTO developer_skill (skill_id, developer_id, effective_from)
VALUES (8,7,'2015-01-01');

-- dev8, JS
INSERT INTO developer_skill (skill_id, developer_id, effective_from)
VALUES (3,8,'2015-01-01');

-- dev9, JS
INSERT INTO developer_skill (skill_id, developer_id, effective_from)
VALUES (3,9,'2015-01-01');
