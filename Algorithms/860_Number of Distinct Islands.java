public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public int numberofDistinctIslands(int[][] grid) {
        HashSet<List<List<Integer>>> set = new HashSet();
        
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j]==1){
                    List<List<Integer>> island = new ArrayList();
                    dfs(grid, i, j, island, 0, 0);
                    set.add(island);
                }
            }
        }
        
        return set.size();
    }
    
    private void dfs(int[][] grid, int i, int j, List<List<Integer>> island, int x, int y){
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length ||
        grid[i][j]==0) return;
        
        grid[i][j]=0;
        island.add(Arrays.asList(x, y));
        
        dfs(grid, i+1, j, island,x+1, y);
        dfs(grid, i, j+1, island,x, y+1);
        dfs(grid, i-1, j, island, x-1, y);
        dfs(grid, i, j-1, island, x, y-1);
    }
}
