public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        Queue<Pair> queue = new LinkedList<>();

        for (int i=0; i<rooms.length; i++){
            for (int j=0; j<rooms[i].length; j++){
                if (rooms[i][j] == 0){
                    queue.add(new Pair(i, j, 0));
                    
                }
            }
        }
        
        travelMatrix(queue, rooms);
    }
    
    private void travelMatrix(Queue<Pair> queue, int[][] rooms)
    {

            int[] rowArr = {0,1,0,-1};
            int[] colArr = {1,0,-1,0};
            boolean[][] visited = new boolean[rooms.length][rooms[0].length];

            while (!queue.isEmpty()){
                Pair p = queue.poll();
                //System.out.println("pair: " + p.getPair1() + " " + p.getPair2());
                for (int k=0; k<4; k++){
                    int row = p.getPair1() + rowArr[k];
                    int column = p.getPair2() + colArr[k];

                    if (isSafe(rooms, row, column) && !visited[row][column]) {
                        int dist = p.getDistance();
                        //System.out.println("row: " + row + " col: " + column + " dist: " + dist);
                        queue.add(new Pair(row, column, dist + 1));
                        rooms[row][column] = Math.min(rooms[row][column],  dist + 1);
                        visited[row][column] = true;
                    }
                }
            }
    }

    private boolean isSafe(int[][] rooms, int i, int j)
    {
        if (i>=0 && i<rooms.length && j>=0 && j<rooms[i].length && rooms[i][j] != -1 && rooms[i][j]!=0) return true;

        return false;
    }
    
    public class Pair<T, T1> {
    private Integer pair1;
    private Integer pair2;
    private Integer distance;

    public Pair(Integer pair1, Integer pair2, Integer distance){
        this.pair1 = pair1;
        this.pair2 = pair2;
        this.distance = distance;
    }



    public Integer getPair1() {
        return pair1;
    }

    public void setPair1(Integer pair1) {
        this.pair1 = pair1;
    }

    public Integer getPair2() {
        return pair2;
    }

    public void setPair2(Integer pair2) {
        this.pair2 = pair2;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
}
