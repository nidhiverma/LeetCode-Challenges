# Write your MySQL query statement below
Select MAX(Salary) as 'SecondHighestSalary'
from Employee 
WHERE Salary NOT IN (Select MAX(Salary) from Employee)
Order By Salary;