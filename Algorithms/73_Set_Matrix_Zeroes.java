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
