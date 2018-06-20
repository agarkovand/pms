/*
Priciest Project based on the Developers' Salaries.

This routine finds the priciest project in the month which holds the date specified - in our example it is the priciest project in the May 2016 as we submit the 2016-05-01 date as a search criteria.
*/

/*
Temp Table to store all project ids with their respective developer ids and their hours for the month which holds the date specified.
*/
CREATE TEMPORARY TABLE IF NOT EXISTS prh AS
SELECT  project_id AS pr_id,
        developer_id AS dev_id,
        hours_per_week AS hours
                
        FROM project_developer

        WHERE   start_date  <= '2016-05-01'
        AND     (end_date    >= '2016-05-01'
        OR      end_date    IS NULL);

/*
Temp Table to store all developer ids with their respective salaries for the month which holds the date specified.
*/
CREATE TEMPORARY TABLE IF NOT EXISTS dev AS
    SELECT  developer_id AS dev_id,
            monthly_salary AS salary
    FROM developer_it_company
    WHERE   start_date  <= '2016-05-01'
    AND     (end_date    >= '2016-05-01'
    OR      end_date    IS NULL);


/*
Temp Table to calculate total cost for each project.
*/
CREATE TEMPORARY TABLE IF NOT EXISTS costs1 AS  
    SELECT prh.pr_id AS pr_id,
           /*
           Sum up all developers salaries broken down by project ids. Salaries stated per month, hours - per week. A week has 40 working hours.
            */
           SUM(dev.salary * prh.hours / 40) AS cost
    FROM  prh
    INNER JOIN dev
    ON prh.dev_id = dev.dev_id
    GROUP BY prh.pr_id;

/*
Create copy of temp table
*/
CREATE TEMPORARY TABLE IF NOT EXISTS costs2 AS
SELECT * FROM costs1;

/*
Select Priciest Project
*/
SELECT * FROM costs1
WHERE costs1.cost = (SELECT MAX(cost) maxp FROM costs2);
