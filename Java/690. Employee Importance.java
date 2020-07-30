/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Employee ee = null;
        Collections.sort(employees, (a,b)->
                         {
                         if(b.id<a.id)
                         {
                             return 1;
                         }
                             else
                             {
                                 return -1;
                             }
                         });
        int impsum =0;
        for(Employee e:employees)
        {
            if(e.id ==id)
            {
                ee = e;
            }
        }    
        impsum = ee.importance;
        List<Integer> sub = ee.subordinates;
        for(int i=0;i<employees.size();i++)
        {
            if(sub.contains(employees.get(i).id))
            {
                impsum = impsum+ employees.get(i).importance;
                sub.addAll(employees.get(i).subordinates);
            }
        }   
    return impsum;
    }
}