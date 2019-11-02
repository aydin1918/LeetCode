/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    private static ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
    
    public static void pathSumInner(TreeNode A, int B, Stack<Integer> path)
    {
        path.push(A.val);
        
        if (A.left == null && A.right == null)
        {
            if (B == A.val) resultList.add(new ArrayList<Integer>(path));
        }
        
        if (A.left !=null)
            pathSumInner(A.left, B - A.val, path);
        if (A.right != null)    
            pathSumInner(A.right, B - A.val, path);
        
        path.pop();
    }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        if (A == null)
        {
            return resultList;
        }
        
        Stack<Integer> stack = new Stack<>();
        pathSumInner(A, B, stack);
        
        return resultList;
        
    }
    
    
}


/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    private static ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
    
    public void pathSum(TreeNode node, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
        if(node == null)
            return;
        int currentVal = node.val;
        temp.add(currentVal);
        if(node.left == null && node.right == null){
            if(sum - currentVal == 0){
                result.add(new ArrayList<Integer>(temp));
            }
        }
        pathSum(node.left, sum - node.val, result, temp);
        pathSum(node.right, sum - node.val, result, temp);
        temp.remove(temp.size() - 1);
        
    }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(A == null)
            return null;
        // temp.add(root.val);
        pathSum(A, B, result, temp);
        return result;
        
    }
    
    
}
