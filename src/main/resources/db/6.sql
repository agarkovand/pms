/*
Average Salary of Programmers in the Least Profitable Project.
*/

/*
Select all projects active in the month which holds the date specified. And calculate the budgets allocated for the projets.
*/
CREATE TEMPORARY TABLE IF NOT EXISTS budgets AS
    SELECT  project_id pr_id,
            SUM(monthly_budget) budget

    FROM it_company_project

        WHERE   start_date  <= '2016-05-01'
        AND     (end_date    >= '2016-05-01'
        OR      end_date    IS NULL)
    
    GROUP BY project_id;

/*
Select all developers and their respective hours assigned to all projects in the month which holds the date specified.
*/
CREATE TEMPORARY TABLE IF NOT EXISTS devs AS
    
    SELECT  project_id pr_id,
            developer_id id,
            hours_per_week hours
            
    FROM project_developer

        WHERE   start_date  <= '2016-05-01'
        AND     (end_date    >= '2016-05-01'
        OR      end_date    IS NULL);
        

/*
Select salaries of all developers in the month which holds the date specified.
*/
CREATE TEMPORARY TABLE IF NOT EXISTS salaries AS

    SELECT  developer_id dev_id,
            monthly_salary salary
    
    FROM developer_it_company

        WHERE   start_date  <= '2016-05-01'
        AND     (end_date    >= '2016-05-01'
        OR      end_date    IS NULL);


/*
Calculate actual costs per each project.
*/
CREATE TEMPORARY TABLE IF NOT EXISTS costs AS

    SELECT  devs.pr_id pr_id,
            SUM(salaries.salary * devs.hours / 40) cost

    FROM devs
    INNER JOIN salaries
    ON devs.id = salaries.dev_id

    GROUP BY devs.pr_id;

/*
Calculate profits per each project.
*/    
CREATE TEMPORARY TABLE IF NOT EXISTS profits1 AS

    SELECT  b.pr_id pr_id,
            (b.budget - c.cost) profit

    FROM budgets b
    INNER JOIN costs c
    ON b.pr_id = c.pr_id;

/*
Copy previous Temp Table.
*/
CREATE TEMPORARY TABLE IF NOT EXISTS profits2 AS
SELECT * FROM profits1;

/*
Find id of the least profitable project.
*/
SET @least_profit_pr_id =

    (SELECT pr_id
    FROM profits1
    WHERE profit = (SELECT MIN(profit) FROM profits2));

/*
Select only salaries for the least profitable project and calculate average salary. Count of selected rows designates the number of developers involved in the project (each developer shows itself only once per project per month).
*/
SELECT  
    SUM(salaries.salary * pd.hours_per_week / 40) / COUNT(*)
    AS avg_salary

FROM project_developer pd
INNER JOIN salaries
ON pd.developer_id = salaries.dev_id
    
    WHERE project_id = @least_profit_pr_id
    AND     start_date  <= '2016-05-01'
    AND     (end_date    >= '2016-05-01'
    OR      end_date    IS NULL);
