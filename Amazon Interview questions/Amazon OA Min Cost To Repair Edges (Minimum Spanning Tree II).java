import java.util.*;

public class Solution {
    public int minCostToRepairEdges(int n, int[][] edges, int[][] edgesToRepair) {
        int ans = 0;
        
        HashSet<NodeSet> set = new HashSet<>();
        List<Node>[] graph = new List[n+1];
        for (int i=0; i<n+1; i++){
            graph[i] = new ArrayList();
        }

        for (int[] edge : edgesToRepair){
            graph[edge[0]].add(new Node(edge[1], edge[2]));
            graph[edge[1]].add(new Node(edge[0], edge[2]));
            set.add(new NodeSet(edge[0], edge[1]));
            set.add(new NodeSet(edge[1], edge[0]));
        }

        for (int[] edge : edges){
            if (set.contains(new NodeSet(edge[0], edge[1]))) continue;
            if (set.contains(new NodeSet(edge[1], edge[0]))) continue;
            graph[edge[0]].add(new Node(edge[1], 0));
            graph[edge[1]].add(new Node(edge[0], 0));
        }



        boolean[] visited = new boolean[n+1];
        int[] parent = new int[n+1];
        int[] dest = new int[n+1];
        Arrays.fill(dest, Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> (o1[1]-o2[1])) ; // first element: next dest / second element: weight
        queue.add(new int[]{1,0});

        /*for (int i=0; i<graph.length; i++){
            for (int j=0; j<graph[i].size(); j++){
                //queue.add(new int[]{graph[i].get(j).dest, graph[i].get(j).weight});
                System.out.println(i + " " + graph[i].get(j).dest);
            }

        }*/

        while (!queue.isEmpty()){
            int[] element = queue.poll();
            if (!visited[element[0]]) ans+=element[1];
            visited[element[0]] = true;

            for (Node node : graph[element[0]]){
                if (!visited[node.dest]){
                    if (dest[node.dest] > node.weight){
                        queue.add(new int[]{node.dest, node.weight});
                        dest[node.dest]  = node.weight;
                    }
                }
            }
        }

        /*for (int i=0; i<dest.length; i++){
            if (dest[i] == Integer.MAX_VALUE) continue;
            ans += dest[i];
        }*/

        return ans;
    }
    
    class Node {
        int dest;
        int weight;
        
        public Node (int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    class NodeSet {
        int src;
        int dest;
        public NodeSet(int s, int d){
            this.dest = d;
            this.src = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NodeSet nodeSet = (NodeSet) o;
            return src == nodeSet.src &&
                    dest == nodeSet.dest;
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, dest);
        }
    }
}
