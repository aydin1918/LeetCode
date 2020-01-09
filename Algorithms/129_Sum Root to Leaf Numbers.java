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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        
        Stack<TreeNode> stack = new Stack();
        int sum = 0;
        
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            int value = node.val;
            
            if (node.right != null)
            {
                node.right.val = node.right.val  + value * 10;
                stack.push(node.right);
            }
            
            if (node.left != null)
            {
                node.left.val = node.left.val  + value * 10;
                stack.push(node.left);
            }
            
           
            
             if (node.left==null && node.right==null) sum += value;
        }
        
        return sum;
        
    }
    
    private int sum(TreeNode root, int sum)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return sum * 10 + root.val;
        
        return sum(root.left, sum*10 + root.val) + sum(root.right, sum*10 + root.val) ;
    }
    
}
