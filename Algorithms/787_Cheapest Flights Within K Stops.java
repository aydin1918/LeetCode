class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Edge>[] graph = new List[n];
        
        for (int i=0; i<n; i++){
            graph[i] = new ArrayList();
        }
        
        for (int i=0; i<flights.length; i++){
            graph[flights[i][0]].add(new Edge(flights[i][0],flights[i][1],flights[i][2]));
            
        }
        
        
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b)-> a[0]-b[0]);
        
        queue.add(new int[]{0, src, K+1});
        
        while (!queue.isEmpty()){
            int[] node = queue.poll();
            
            int price = node[0];
            int city = node[1];
            int stops = node[2];
            if (city == dst) return price;
            
            if (stops > 0){
                for (Edge edge : graph[city]){
                    int newprice = price + edge.price;
                    queue.add(new int[]{newprice, edge.destination, stops-1});
                }
            }
            
        }
        
        return -1;
    }
    
    
    class Edge {
        int source;
        int destination;
        int price;
        public Edge(int s, int d, int w){
            this.source = s;
            this.destination = d;
            this.price = w;
        }
    }
}
