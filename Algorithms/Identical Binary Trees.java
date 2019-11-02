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
    public int isSameTree(TreeNode A, TreeNode B) {
      
        
        return (isSameTreeBool(A, B)) ? 1 : 0;
     
    }
    
    public boolean isSameTreeBool(TreeNode A, TreeNode B) {
     
        if (A == null && B == null)
        {
            return true;
        }
        if (A!=null && B!=null)
        {
            return (A.val == B.val && isSameTreeBool(A.left, B.left) && isSameTreeBool(A.right, B.right));
        }
        
        return false;
     
    }
    
    
}
