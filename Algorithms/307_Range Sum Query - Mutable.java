class NumArray {
    
    private TreeNode root = null;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        this.root = buildTree(nums, 0, nums.length-1);
    }
    
    public void update(int i, int val) {
        TreeNode curr = this.root;
        updateHelper(curr, i, val);
    }
    
    private void updateHelper(TreeNode node, int i, int val){
        if (node == null) return;
        
        int mid = node.start + (node.end - node.start)/2;
        if (i<=mid){
            updateHelper(node.left, i, val);
        }
        else {
            updateHelper(node.right, i, val);
        }
        
        if (node.start == node.end && node.start == i){
            node.sum = val;
            return;
        }
        
        node.sum = node.left.sum + node.right.sum;
    }
    
    public int sumRange(int i, int j) {
        TreeNode curr = this.root;
        
        return sumHepler(curr, i, j);
    }
    
    private int sumHepler(TreeNode node, int start, int end){
        if (node == null || start > end || node.start > end || node.end < start) return 0;
        
        if (start <= node.start && end >= node.end ) return node.sum;
        
        int mid = node.start + (node.end-node.start)/2;
        
        int sum1 = sumHepler(node.left, start, Math.min(end, mid));
        int sum2 = sumHepler(node.right, Math.max(start, mid+1), end);
        
        return sum1 + sum2;
    }
    
    private TreeNode buildTree(int[] nums, int start, int end){
        if (nums.length == 0 || start>end) return null;
        
        if (start==end) return new TreeNode(start, end, nums[end]);
        
        TreeNode node = new TreeNode(start, end);
        
        int mid = start + (end-start)/2;
            
        node.left = buildTree(nums, start, mid);
        node.right = buildTree(nums, mid+1, end);
        
        node.sum = node.left.sum + node.right.sum;
        
        return node;
    }
    
    class TreeNode {
        int start;
        int end;
        int sum;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int start, int end, int sum){
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
        
        public TreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.sum = 0;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
