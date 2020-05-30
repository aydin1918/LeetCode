class Solution {
    
    public int networkDelayTime(int[][] times, int N, int K) {
        int result = -1;
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.pathLength - o2.pathLength);
       
        
        Graph graph = new Graph(N);
        
        for (int[] arr : times){
            graph.addEdge(arr[0]-1, arr[1]-1, arr[2]);
            //System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }
        
        boolean[] SP = new boolean[N];
        int[] destination = new int[N];
        
        Arrays.fill(destination, Integer.MAX_VALUE);
        destination[K-1] = 0;
        
        queue.add(new Pair(0, K-1)); // first is total length, second is Node
        
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            int totalDestination = pair.pathLength;
            int vertex = pair.node;
            
            if (!SP[vertex]){
                SP[vertex] = true;
                
                for (Edge edge : graph.adj[vertex]){
                    
                    //System.out.println("vertex: " + vertex + " - " + (totalDestination + edge.weight));
                    
                    if (destination[edge.destination] >  totalDestination + edge.weight){
                        
                        destination[edge.destination] = totalDestination + edge.weight;
                        queue.add(new Pair(destination[edge.destination], edge.destination));
                        //result = Math.max(result, totalDestination);
                    }
                }
            }
        }
        
        for (int a: destination){
            if (a == Integer.MAX_VALUE) return -1;
            //System.out.println(a);
            result = Math.max(result, a);
        }
        
        
        return result;
    }
    
    class Edge {
        private int source;
        private int destination;
        private int weight;
        
        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    
    class Graph {
        private int V;
        private List<Edge>[] adj;
        
        public Graph(int v){
            this.V = v;
            this.adj = new List[v];
            for (int i=0; i<v; i++){
                this.adj[i] = new ArrayList();
            }
        }
        
        public void addEdge(int source, int destination, int weight)
        {
            Edge edge = new Edge(source, destination, weight);
            this.adj[source].add(edge);
            
            //Edge edge1 = new Edge(destination, source, weight);
            //this.adj[destination].add(edge1);
        }
    }
    
     class Pair<T1, T2> {
        public int pathLength;
        public int node;
        
        public Pair(int a, int b){
            this.pathLength = a;
            this.node = b;
        }
        
    }
}
