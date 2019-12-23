class Solution {
    public void setZeroes(int[][] matrix) {
        int[] firstRow = new int[matrix[0].length];
        int[] firstColumn = new int[matrix.length];
        Arrays.fill(firstColumn, 1);
        Arrays.fill(firstRow, 1);

        for (int i=0; i<matrix.length; i++)
        {
            for (int j=0; j<matrix[i].length; j++)
            {
                if (matrix[i][j] == 0)
                {
                    firstColumn[i] = 0;
                    firstRow[j] = 0;
                }
            }
        }

        for (int i=0; i<matrix.length; i++)
        {
            for (int j=0; j<matrix[i].length; j++)
            {
                if (firstColumn[i] == 0 || firstRow[j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}


//-----------------------

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean initElementIsZero = matrix[0][0] == 0;
        boolean row = false, column = false;

        for (int i=0; i<matrix.length; i++)
        {
            if (matrix[i][0] == 0) {
                column = true;
            }
            for (int j=1; j<matrix[i].length; j++)
            {
                if (matrix[i][j]==0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (column)
        {
            for (int i=0; i<matrix.length; i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}



//--------------------------------

class Solution {
    public void setZeroes(int[][] matrix) {
        //2.Using constant space O(m * n) O(1)
        int r = matrix.length;
        int c = matrix[0].length;
        boolean fr = false;
        boolean fc = false;
        
        //check first row
        for (int j = 0; j < c; j++) {
            if (matrix[0][j] == 0) {
                fr = true;
                break;
            }
        }
        //check first column
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                fc = true;
            }
        }
        //O(m * n) scan
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //O(m * n) set
        for (int i = 1; i < r; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < c; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < c; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < r; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        //set first row & column
        if (fr) {
            for (int j = 0; j < c; j++) {
                matrix[0][j] = 0;
            }
        }
        if (fc) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
