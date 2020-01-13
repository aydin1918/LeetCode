/*
 Runtime: 32 ms, faster than 5.37% of Java online submissions for Path Sum II.
 Memory Usage: 43 MB, less than 6.06% of Java online submissions for Path Sum II.
*/
class Solution {
    
    class ExtendetClass
    {
        TreeNode node = null;
        int currentSum = 0;
        List<Integer> list;
        public ExtendetClass(TreeNode node, int sum, ArrayList<Integer> list)
        {
            this.node = node;
            this.currentSum = sum;
            this.list = list;
        }
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<ExtendetClass> stack = new Stack();
        
        ExtendetClass ext = new ExtendetClass(root, sum, new ArrayList());
        stack.push(ext);
        
        while (!stack.isEmpty())
        {
            ExtendetClass temp = stack.pop();
            List<Integer> tempList = temp.list;
            tempList.add(temp.node.val);
            temp.currentSum = temp.currentSum - temp.node.val;
            if (temp.currentSum == 0 && (temp.node.right==null && temp.node.left==null)) 
            {
                res.add(tempList); 
            }
            System.out.println(temp.node.val + " isEmpty: " + stack.isEmpty() + " sum : " + (temp.currentSum));
            
            
            if (temp.node.right!=null)
            {
                stack.push(new ExtendetClass(temp.node.right, temp.currentSum, new ArrayList(tempList)));
            }
            
            if (temp.node.left!=null)
            {
                stack.push(new ExtendetClass(temp.node.left, temp.currentSum, new ArrayList(tempList)));
            }
            
            
        }
        
        return res;
    }
}

/*
Runtime: 2 ms, faster than 35.01% of Java online submissions for Path Sum II.
Memory Usage: 39.7 MB, less than 19.69% of Java online submissions for Path Sum II.
*/

class Solution {
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        return deepInto(res, root, sum, new ArrayList<Integer>());
    }
    
    private List<List<Integer>> deepInto(List<List<Integer>> res, TreeNode root, int sum, ArrayList<Integer>                                             list)
    {
        if (root == null) return res;
        
        list.add(root.val);
           //System.out.println(root.val + " list: " + list);
        int currSum = sum - root.val;
        if (root.left == null && root.right == null && currSum == 0)
        {
            res.add(list);
            //list = new ArrayList<Integer>();
            return res;
        }
        
        if (root.left!=null)
        {
            deepInto(res, root.left, currSum, new ArrayList<Integer>(list));
        }
        
        if (root.right!=null)
        {
            deepInto(res, root.right, currSum, new ArrayList<Integer>(list));
        }
        
        return res;
    }
    
}
