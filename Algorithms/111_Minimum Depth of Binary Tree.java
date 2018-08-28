/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public int minDepth(TreeNode root) {
        int result = GetHeight(root);
        return result;
    }
    
    private static int GetHeight(TreeNode root)
    {
        int l_height = 0;
        int r_height = 0; 
            
        if (root == null)
        {
            return 0;
        }
        else
        {
            /*if (root.left != null && root.right != null)
            {
                
            }*/
            
            if (root.left !=null && root.right == null)
            {
                l_height = GetHeight(root.left);
                return l_height+1;
            }
            if (root.left ==null && root.right != null)
            {
                r_height = GetHeight(root.right);
                return r_height+1;
            }
            l_height = GetHeight(root.left);
            r_height = GetHeight(root.right);
            return Math.min(l_height, r_height)+1;
        }
    }
}
