
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (int[] a, int[] b) -> {
           int diff1 = a[0]*a[0] + a[1]*a[1];
           int diff2 = b[0]*b[0] + b[1]*b[1];
            
            return diff1-diff2;
        });
        return Arrays.copyOfRange(points, 0, K);
    }
}

/***
***
***/
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((int[] a, int[] b) -> {
            int dist1 = a[0]*a[0] + a[1]*a[1];
            int dist2 = b[0]*b[0] + b[1]*b[1];
            
            return dist2-dist1;
        });
        
        for (int i=0; i<points.length; i++){
            
            queue.add(points[i]);
            if (queue.size()>K) queue.poll();
        }
        
        while (!queue.isEmpty()){
            ans[--K] = queue.poll();
        }
        
        return ans;
    }
}
