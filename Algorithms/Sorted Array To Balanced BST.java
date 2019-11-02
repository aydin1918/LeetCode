/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    static TreeNode root;
    
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        
        TreeNode root = null;
        
        root = sortedArrayUtil(a, 0,  a.size()-1);
        
        return root;
    }
    
    
    public static TreeNode sortedArrayUtil (final List<Integer> a, int left, int right)
    {

        if (left>right)
        {
            return null;
        }
        
        int middle = (left + right)/2;
        
        TreeNode node = new TreeNode(a.get(middle));
        node.left = sortedArrayUtil(a, left, middle-1);
        node.right = sortedArrayUtil(a, middle+1, right);
        
        return node;
    }
}
