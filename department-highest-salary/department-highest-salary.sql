# Write your MySQL query statement below
With HighestSalary as (Select Max(Salary) as 'MaxSalary', DepartmentId as 'Id' From Employee Group By DepartmentId)
Select d.Name as 'Department', e.Name as 'Employee', e.Salary as 'Salary'
From Employee e, HighestSalary h, Department d
Where e.Salary = h.MaxSalary AND e.DepartmentId = h.Id AND d.Id = h.Id