import java.util.stream.Collectors;

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
    
    public int sumNumbers(TreeNode A) {
        
        
        
        return sumPathUtil(A, 0)%1003;
    }
    
    public static int sumPathUtil(TreeNode A, int val)
    {
        if (A == null)
        {
            // finish. came to leaf
            //leafSum.add(path.stream().collect(Collectors.summingInt(Integer::intValue)));
            return 0;
        }
        
        val = (val * 10 + A.val)%1003;
        
        if (A.left == null && A.right == null)
        {
            return val%1003;
        }
        
        return  sumPathUtil(A.left, val) + sumPathUtil(A.right, val);
        
    }
    
}
