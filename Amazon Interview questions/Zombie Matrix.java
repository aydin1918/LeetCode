import java.util.*;

public class Solution {
    private int rows[] = {1, 0, -1, 0};
    private int cols[] = {0, -1, 0, 1};
    
	public int humanDays(int[][] matrix) {
	    if (matrix == null || matrix.length == 0) {
            return -1;
        }
        
		int days = 0, count = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for (int i=0; i<matrix.length; i++){
		    for (int j=0; j<matrix[0].length; j++){
		        if (matrix[i][j]==1){
		            queue.add(new int[]{i,j});
		        }
		        else count++;
		    }
		}
		
		if (count == matrix.length * (matrix[0].length == 0 ? 1 : matrix[0].length) ) return -1;
		
		while (!queue.isEmpty() && count>0){
		    int sizeQ = queue.size();
		    
		    for (int i=0; i<sizeQ; i++){
		        int[] node = queue.poll();
		        
		        for (int j=0; j<4; j++){
		            int newX = node[0] + rows[j];
		            int newY = node[1] + cols[j];
		            if (newX<0 || newY<0 || newX>=matrix.length || newY>=matrix[0].length || matrix[newX][newY]==1) continue;
		            matrix[newX][newY]=1;
		            queue.add(new int[]{newX, newY});
		            count--;
		        }
		    }
		    days++;
		}
		
		return days;
	}
}
