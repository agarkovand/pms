/* 
Total Salary for Java developers.

This routine calculates total monthly salary for all Java developers on the specified date. In our example total monthly salary for the May 2016 is calculated as we submit '2016-05-01' as a search criteria.
*/


/*
Find all developers who qualify for the date and skill specified.
*/

CREATE TEMPORARY TABLE dev AS
SELECT developer_id id
FROM developer_skill ds
INNER JOIN skill s
ON ds.skill_id = s.id
WHERE ds.effective_from <= '2016-05-01'
AND s.area_of_expertise LIKE '%Java%';

/*
Sum up all salaries which correspond to the date specified for all selected developers.
*/

SELECT SUM(sal.monthly_salary)
FROM developer_it_company sal
INNER JOIN dev
ON sal.developer_id = dev.id
    WHERE   start_date <= '2016-05-01'
    AND     (end_date >= '2016-05-01'
    OR      end_date IS NULL);
