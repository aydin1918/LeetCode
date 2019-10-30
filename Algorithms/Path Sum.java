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
    
    public static boolean resultB = false;
    
    public int hasPathSum(TreeNode A, int B) {
        
        //sum(A,B);
        //return (resultB == true) ? 1 : 0;
        return (sum1(A, B)) ? 1 : 0;
    }
    
    public static boolean sum1(TreeNode A, int B)
    {
        boolean res = false;
        
        if (A == null)
        {
            return (B==0);
        }
        
        int sum = B - A.val;
        
        if (0 == sum && A.left == null && A.right ==null)
        {
            return true;
        }
        
        if (A.left != null)
        {
            res = res || sum1(A.left, sum);
        }
        
        if (A.right != null)
        {
            res = res || sum1(A.right, sum);
        }
        
        //sum = left + right;
        
        return res;
    }
    
    
}
