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
    public int kthSmallest(TreeNode root, int k) {
    
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        int count = 0, minKthElement = 0;
        
        while (node!=null || stack.size()>0)
        {
            while (node!=null)
            {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            count++;
            if (count == k)
            {
                return node.val;
            }
            System.out.println(node.val + " count: " + count);
            node = node.right;
        }
        
        return minKthElement;
        //----end-----
    }
    
}
