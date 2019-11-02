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
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        
        TreeNode temp = A;
        
        while (temp!=null || stack.size()>0)
        {
            
            while (temp != null)
            {
                stack.push(temp);
                temp = temp.left;
            }
            
            
            temp = stack.pop();
            arrayList.add(temp.val);
            
            temp = temp.right;
            
        }
        return arrayList;
    }
}
