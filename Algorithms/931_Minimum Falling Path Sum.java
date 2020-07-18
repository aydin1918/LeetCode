class Solution {
    public int minFallingPathSum(int[][] A) {
        int ans = Integer.MAX_VALUE;
        int[][] memo = new int[A.length][A.length];
        
        for (int i=0; i<A.length; i++){
            ans = Math.min(ans, findMinSum(A, 0, i, memo));
        }
        
        return ans;
    }
    
    private int findMinSum(int[][] A, int row, int col, int[][] memo)
    {
        if (row==A.length-1) {
            return A[row][col];
        }
        
        if (memo[row][col]!=0) return memo[row][col];
        
        int sumTemp = Integer.MAX_VALUE;
        int val = A[row][col];
        
        if (col-1>=0) {
            sumTemp = Math.min(val + findMinSum(A, row+1, col-1, memo), sumTemp);
        }
        
        if (col+1 < A.length){
            sumTemp = Math.min(val + findMinSum(A, row+1, col+1, memo), sumTemp);
        }
        
        sumTemp = Math.min(val + findMinSum(A, row+1, col, memo), sumTemp);
        
        return memo[row][col] = sumTemp;
    }
}
