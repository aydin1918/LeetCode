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
    
    public int max = 0;
    public int count = 1;
    public Integer prevEl = null;
    
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList();    
        travel(root, list);
        int[] arr = new int[list.size()];
        for (int i=0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    
    public void travel(TreeNode root, List<Integer> list)
    {
        if (root == null) return;
        travel(root.left, list);
        
        int currEl = root.val;
        
        if (prevEl != null){
            if (prevEl == currEl){
                count++;
            }
            else {
                count = 1;
            }
        }
        
        
        if (count > max ){
            max = count;
            list.clear();
            list.add(currEl);
        }
        else if (count == max) {
            list.add(currEl);
        }
        prevEl = currEl;
        
        travel(root.right, list);
    }
}
