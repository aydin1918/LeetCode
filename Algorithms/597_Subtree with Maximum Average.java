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
    private int[] maxRes;
    private TreeNode avg;
     
    public TreeNode findSubtree2(TreeNode root) {
        if (root == null) return null;
        int[] arr = dfs(root);
        
        /*if (this.average < (arr[1]+root.val)/arr[0]+1 ){
            this.avg = root;
        }*/
        
        return this.avg;
    }
    // int[] arr -> {number of children in node, their sums}
    private int[] dfs(TreeNode root){
        if (root == null) return new int[]{0, 0};
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        int sum = left[1]+right[1]+root.val;
        int count = left[0] + right[0] + 1;
        int[] result = new int[]{count, sum};
        
        if (this.avg == null || maxRes[1] * count < maxRes[0] * sum){
            //System.out.println(root.val);
            this.avg = root;
            this.maxRes = result;
        }
        
        /*System.out.println("root: " + root.val + " left: " + left[1] + " right[1]: " + right[1]);*/
        
        return result;
    }
}
