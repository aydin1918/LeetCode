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
