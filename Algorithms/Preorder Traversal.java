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
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        
        stack.push(A);
        
        while (stack.size()>0)
        {
            TreeNode temp = stack.pop();
            arrayList.add(temp.val);
            
            if (temp.right!=null)
            {
                stack.push(temp.right);
            }
            
            if (temp.left!=null)
            {
                stack.push(temp.left);
            }
            
            
        }
        return arrayList;
    }
}
