/*
   Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Paths.
  Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Binary Tree Paths.
*/

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList();
        StringBuilder builder = new StringBuilder();
        if (root == null) return list;
        return deepInto(list, root, builder);
    }
    
    private List<String> deepInto(List<String> list, TreeNode root, StringBuilder builder)
    {
        if (root == null) return list;
        
        builder.append(root.val);
        
        if (root.left == null && root.right == null) 
        {
            list.add(builder.toString());
            return list;
        }
        builder.append("->");
        
        if (root.left != null)
        {
            deepInto(list, root.left, new StringBuilder(builder));
        }
        
        if (root.right != null)
        {
            deepInto(list, root.right, new StringBuilder(builder));
        }
        
        return list;
    }
}

/*
Runtime: 2 ms, faster than 14.60% of Java online submissions for Binary Tree Paths.
Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Binary Tree Paths.
*/
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack();
        Stack<String> strStack = new Stack();
        
        stack.push(root);
        strStack.push("");
        
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            String str = strStack.pop();
            
            if (node.left == null && node.right == null) list.add(str + node.val);
            
            if (node.right!=null)
            {
                stack.push(node.right);
                strStack.push(str + node.val + "->");
            }
            
            if (node.left!=null)
            {
                stack.push(node.left);
                strStack.push(str + node.val + "->");
            }
        }
        
        return list;
    }
}
