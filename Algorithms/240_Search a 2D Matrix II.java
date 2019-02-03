class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length < 1 || matrix[0].length <1)
        {
            return false;
        }
        
        int col = 0, row = matrix[0].length-1;
        
        while(row>=0 && col<=matrix.length-1)
        {
            System.out.println("row: " + row + " col: " + col);
            if (matrix[col][row]==target)
            {
                return true;
            }
            if (matrix[col][row]>target)
            {
                row--;
            }
            else
            {
                col++;
            }
        }
        
        return false;
        
    }
    
    
}
