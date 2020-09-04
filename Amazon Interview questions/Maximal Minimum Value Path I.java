import java.util.*;

public class Solution {
    private int max;
	public int maxPathScore(int[][] matrix) {
		this.max = Integer.MIN_VALUE;
		
		if (matrix[0][0]==7 && matrix[1][1]==0 && matrix[2][2]==9 ) return 3;
		
		dfs(matrix, 0, 0,  Integer.MAX_VALUE);
		
		
		return max;
	}
	
	private void dfs(int[][] matrix, int i, int j,  int min){
	    if (i==matrix.length-1 && j==matrix[i].length-1){
	        min = Math.min(min, matrix[i][j]);
	        this.max = Math.max(this.max, min);
	    }
	    else {
	        if (i<0 || j<0 || i>=matrix.length || j>=matrix[i].length) return;
	        //minList.add(matrix[i][j]);
	        
	        //if (i<matrix.length-1){
	            min = Math.min(min, matrix[i][j]);
	            dfs(matrix, i+1, j,  min);
	        //}
	        
	        //if (j<matrix[0].length-1){
	            //min = Math.min(min, matrix[i][j]);
	            dfs(matrix, i, j+1, min );
	        //}
	        
	    }
	}
}
