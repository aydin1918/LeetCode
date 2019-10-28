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
    int isValid=1; // keeps track of whether the tree is balanced or not
    public int isBalanced(TreeNode A) 
    {
        recurse(A);
        return isValid;
    }
    public int recurse(TreeNode A) // DFS approach
    {
        int left=0,right=0;// keeps track of the depth of the right and left subtree
        if(A.left!=null)
        {
            left=recurse(A.left);
        }
        if(A.right!=null)
        {
            right= recurse(A.right);
        }
        if(Math.abs(right-left)>1) 
        {
            isValid=0;// not a balanced tree
        }
        return 1+Math.max(right,left);
    }
}
