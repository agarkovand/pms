/*
Least profitable Client per each IT Company.

This routine calculates the least profitable Client per each It Company in the month which holds the date specified. In our example it is the May 2016 as we submit '2016-05-01' as a search criteria.
*/

CREATE TEMPORARY TABLE IF NOT EXISTS budgets AS
    SELECT  pr.id pr_id,
            pr.customer_id cust_id, 
            compr.monthly_budget budget,
            compr.it_company_id comp_id
    FROM project pr
    INNER JOIN it_company_project compr 
    ON pr.id = compr.project_id
        WHERE   start_date  <= '2016-05-01'
        AND     (end_date    >= '2016-05-01'
        OR      end_date    IS NULL);
    
/*
Temp Table to store all project ids with their respective developer ids and their hours for the month which holds the date specified.
*/
CREATE TEMPORARY TABLE IF NOT EXISTS pr AS
    SELECT project_id AS id,
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
    SELECT developer_id AS id,
           monthly_salary AS salary
                        
    FROM developer_it_company
        WHERE   start_date  <= '2016-05-01'
        AND     (end_date    >= '2016-05-01'
        OR      end_date    IS NULL);
            
            
CREATE TEMPORARY TABLE IF NOT EXISTS costs AS
    SELECT  pr.id pr_id,
            SUM(dev.salary * pr.hours / 40) cost
    FROM  pr
    INNER JOIN dev
    ON pr.dev_id = dev.id
    GROUP BY pr.id;

CREATE TEMPORARY TABLE IF NOT EXISTS all_profits AS
    SELECT  budgets.cust_id cust_id,
            budgets.comp_id comp_id,
            budgets.budget-costs.cost AS per_pr_profit

    FROM budgets
    INNER JOIN costs
    ON budgets.pr_id = costs.pr_id;

    
CREATE TEMPORARY TABLE IF NOT EXISTS sum_profits AS
    SELECT  cust_id,
            comp_id,
            SUM(per_pr_profit) AS per_cust_profit

    FROM all_profits
    GROUP BY all_profits.cust_id, all_profits.comp_id;

    
CREATE TEMPORARY TABLE IF NOT EXISTS min_profits AS
    SELECT  comp_id,
            MIN(per_cust_profit) minp
    FROM sum_profits
    GROUP BY cust_id, comp_id;


SELECT sum_profits.* 
FROM sum_profits
INNER JOIN min_profits
ON sum_profits.per_cust_profit = min_profits.minp
AND sum_profits.comp_id = min_profits.comp_id;
