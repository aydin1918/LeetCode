class Solution {
    public boolean isValidSudoku(char[][] board) {
         return SolveSuduku(board);
    }
    
    
    


    private boolean SolveSuduku(char[][] array) {

        int[] l = {0, 0};
        int row = 0, col = 0;

        if (FindEmpty(array, l) == false) {
            return true;
        }

        //System.out.println("array 'l': " + l[0] + " - " + l[1]);

        row = l[0];
        col = l[1];

        for (int num = 1; num <= 9; num++) {
            if (CheckRow(array, row, num) != true && CheckColumn(array, col, num) != true && CheckSmallMatrix_3x3(array, col - col % 3, row - row % 3, num) != true) {
                array[row][col] = Character.forDigit(num, 10); //String.valueOf(num));

                if (SolveSuduku(array) == true) {
                    return true;
                }
                array[row][col] =  Character.valueOf('.'); //'.'; //String.valueOf(0);
            }

        }
        return false;
    }

    private boolean FindEmpty(char[][] array, int[] loc) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (Character.toString(array[i][j]).equals(".")) {
                    loc[0] = i;
                    loc[1] = j;
                    return true;
                }
            }
        }
        return false;
    }


    private boolean CheckSmallMatrix_3x3(char[][] array, int col_num, int row_num, int digit) {
        for (int ii = 0; ii < 3; ii++) {
            for (int jj = 0; jj < 3; jj++) {
                if (!Character.toString(array[ii + row_num][jj + col_num]).equals(".")) {
                    if (Integer.parseInt(Character.toString(array[ii + row_num][jj + col_num])) == digit) {
                        return true;
                    }
                }

            }
        }
        return false;


    }

    private boolean CheckColumn(char[][] array, int col_num, int digit) {
        for (int i = 0; i < array.length; i++) {
            if (!Character.toString(array[i][col_num]).equals(".")) {
                if (Integer.parseInt(Character.toString(array[i][col_num])) == digit) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean CheckRow(char[][] array, int row_num, int digit) {
        for (int i = 0; i < array.length; i++) {
            if (!Character.toString(array[row_num][i]).equals(".")) {
                //System.out.println("-- " + Character.toString(array[row_num][i]));
                if (Integer.parseInt(Character.toString(array[row_num][i])) == digit) {
                    return true;
                }
            }
        }
        return false;
    }

    
}
