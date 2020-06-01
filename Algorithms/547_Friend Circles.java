class Solution {
    public int findCircleNum(int[][] M) {
        int[] arr = new int[M.length];
        int count = arr.length;

        for (int k=0; k<arr.length; k++) arr[k] = k;

        for (int row=0; row<M.length; row++){
            for (int col=0; col<M.length; col++){
                if (row!=col){
                    int friend1 = find(arr, row);
                    int friend2 = find(arr, col);
                    if (M[row][col] == 1 && M[row][col] == M[col][row] && friend1!=friend2) {
                        arr[friend2] = friend1;
                        count--;
                    }
                }
            }
        }


        return count;
    }
    
    private int find(int[] arr, int i)
    {
        while (arr[i] != i){
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }
}
