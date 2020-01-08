class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int oldColur = image[sr][sc];
        
        if (oldColur != newColor) dfs(image, sr, sc, newColor, oldColur);
        
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int newColor, int oldColur)
    {
        if (i<0 || j<0 || i>=image.length || j>=image[i].length || image[i][j] != oldColur ) return;
        
        image[i][j] = newColor;
        dfs(image, i+1, j, newColor, oldColur);
        dfs(image, i, j+1, newColor, oldColur);
        dfs(image, i-1, j, newColor, oldColur);
        dfs(image, i, j-1, newColor, oldColur);
        
    }
    
    
}
