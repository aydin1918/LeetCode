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
    public int sumOfLeftLeaves(TreeNode root) {
        
        if (root == null) return 0;
        int sum = 0;
        
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
            
        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            
            if (curr.left != null){
                if (curr.left.left == null && curr.left.right == null ){
                    sum += curr.left.val;
                }
                else {
                    stack.add(curr.left);
                }
            }
            
            if (curr.right != null){
                stack.add(curr.right);
            }
        }
        
        return sum;
    }
}
