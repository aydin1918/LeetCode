/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
public class Solution {
    /**
     * @param imput: 
     * @param id: 
     * @return: the total importance value 
     */
    private int ans; 
     
    public int getImportance(List<Employee> employees, int id) {
        this.ans = 0;
        HashMap<Integer, Employee> map = new HashMap();
        
        for (int i=0; i<employees.size(); i++){
            map.put(employees.get(i).id, employees.get(i));
        }
        
        dfs(id, map);
        //System.out.println(map);
        
        return ans;
    }
    
    private void dfs(int curr, HashMap<Integer, Employee> map){
        Employee emp = map.get(curr);
            ans += emp.importance;
            for (int i=0; i<emp.subordinates.size(); i++){
                dfs(emp.subordinates.get(i), map);
            }
        
    }
}
