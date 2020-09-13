/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: a TreeNode
     * @return: a list of integer
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList();
        if (root == null) return ans;
        ans.add(root.val);
        travel(root, ans);
        
        return ans;
    }
    
    private void travel(TreeNode root, List<Integer> list){
        if (root == null) return;
        
        travelLeft(root.left, list);
        
        
            travelLeaf(root.left, list);
            travelLeaf(root.right, list);
        
        
        
        travelRight(root.right, list);
    }
    
    private void travelRight(TreeNode root, List<Integer> list){
        if (root == null) return;
        
        if (root.right!=null){
            travelRight(root.right, list);
            list.add(root.val);
        }
        else if (root.left!=null){
            travelRight(root.left, list);
            list.add(root.val);
        }
    }
    
    private void travelLeaf(TreeNode root, List<Integer> list){
        if (root == null) return;
        
        travelLeaf(root.left, list);
        if (root.left==null && root.right==null){
            list.add(root.val);
        }
        travelLeaf(root.right, list);
    }
    
    private void travelLeft(TreeNode root, List<Integer> list){
        if (root == null) return;
        
        if (root.left!=null){
            list.add(root.val);
            travelLeft(root.left, list);
        }
        else if (root.right!=null) {
            list.add(root.val);
            travelLeft(root.right, list);
        }
    }
    
    
}
