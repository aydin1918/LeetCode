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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int height = height(A);
        //System.out.println("height: " + height);
        int level = 1;
        zigzagUtil(A, result);
        
        return result;
    }
    
    public static void zigzagUtil(TreeNode A, ArrayList<ArrayList<Integer>> result)
    {
        
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        
        currentLevel.push(A);
        TreeNode node = null;
        ArrayList<Integer> temp = new ArrayList<>();

        
        boolean leftSide = true;
        
        while (currentLevel.size()>0)
        {
            node = currentLevel.pop();
            temp.add(node.val);
            
            if (leftSide)
            {
                if (node.left!=null)
                {
                    //zigzagUtil(node.left, result, temp);
                    nextLevel.push(node.left);
                }
                if (node.right!=null)
                {
                    //zigzagUtil(node.right, result, temp);
                    nextLevel.push(node.right);
                }
            }
            else
            {
                if (node.right!=null)
                {
                    //zigzagUtil(node.right, result, temp);
                    nextLevel.push(node.right);
                }
                if (node.left!=null)
                {
                    //zigzagUtil(node.left, result, temp);
                    nextLevel.push(node.left);
                }
                
            }
            
            
            if (currentLevel.isEmpty())
            {
                leftSide = !leftSide;
                Stack<TreeNode> tempStack = currentLevel; 
                currentLevel = nextLevel; 
                nextLevel = tempStack; 
                result.add(temp);
                temp = new ArrayList<>();
            }
            
            // temp.remove(temp.size()-1);
            
        }
    }
    
    public static int height(TreeNode A)
    {
        if (A == null)
        {
            return 0;
        }
        else
        {
            int left = height(A.left);
            int right = height(A.right);
            
            return 1 + Math.max(left, right);
        }
    }
    
}
