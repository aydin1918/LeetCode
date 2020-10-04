/*
* Runtime: 7 ms, faster than 79.57% of Java online submissions for Shortest Bridge.
* Memory Usage: 39.5 MB, less than 99.24% of Java online submissions for Shortest Bridge.
*/

class Solution {
    
    private int[] row = {1,0,-1,0};
    private int[] col = {0,1,0,-1};
    
    public int shortestBridge(int[][] A) {
        int minDist = Integer.MAX_VALUE;
        boolean exit = false;
        // find first island
        for (int i=0; i<A.length; i++){
            if (exit) break;
            for (int j=0; j<A[0].length; j++){
                if (A[i][j]==1){
                    dfs(A, i, j);
                    exit=true;
                    break;
                }
            }
        }
        
        /*for (int i=0; i<A.length; i++){
            for (int j=0; j<A[0].length; j++){
                System.out.println(A[i][j]);
            }
        }*/
        
        Queue<Pair> queue = new LinkedList();
        
        for (int i=0; i<A.length; i++){
            for (int j=0; j<A[0].length; j++){
                if (A[i][j]==1){
                    queue.add(new Pair(i, j, 0));
                }
            }
        }
        
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            
            for (int size=0; size<4; size++){
                int x = pair.i + row[size];
                int y = pair.j + col[size];
                
                if (x<0 || y<0 || x>=A.length || y>= A[0].length || A[x][y]==3) continue;
                
                if (A[x][y]==2) return pair.dist;
                
                A[x][y] = 3;
                
                queue.add(new Pair(x, y, pair.dist+1));
            }
        }
        
        return 0;
    }
    
    private void dfs(int[][] A, int i, int j){
        
        if (i<0 || j<0 || i>=A.length || j>=A[0].length || A[i][j]!=1) return;
        
        A[i][j] = 2; // make visited
        dfs(A, i+1, j);
        dfs(A, i, j+1);
        dfs(A, i-1, j);
        dfs(A, i, j-1);
        
    }
    
    class Pair {
        private int i;
        private int j;
        private int dist;
        
        public Pair(int i, int j, int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
}
/*
0 1
1 0
--------
0,1,0
0,0,0
0,0,1
-------

1,1,1,1,1
1,0,0,0,1
1,0,1,0,1
1,0,0,0,1
1,1,1,1,1

*/
