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
    
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) return false;
        List<Integer> list = new ArrayList();
        dfs(root, list);
        int[] prefixSum = new int[list.size()];
        
        prefixSum[0] = list.get(0);
        for (int i=1; i<list.size(); i++) {
            prefixSum[i] = prefixSum[i-1] + list.get(i);
        }
        
        for (int i=0; i<prefixSum.length-1; i++){
            /*System.out.println(prefixSum[prefixSum.length-1] + " - " +
            prefixSum[i]);*/
            if (prefixSum[prefixSum.length-1]-prefixSum[i] == prefixSum[i]) return true;
        }
        
        return false;
    }
    
    private void dfs(TreeNode root, List<Integer> list){
        if (root == null) return;
        
        list.add(root.val);
        
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
