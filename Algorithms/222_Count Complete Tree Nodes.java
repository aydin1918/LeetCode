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
    public int countNodes(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count =0;
        TreeNode node = root;
        //stack.push(node);
        //count++;
        
        while (node != null || stack.size()>0)
        {
            while (node != null)
            {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.println(node.val);
            node = node.right;
            count++;
        }
        
        
        return count;
        //------
    }
}
