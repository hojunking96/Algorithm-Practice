import java.util.*;

class Solution {
    
    private class Edge {
        int v;
        int cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    
    private static final List<List<Edge>> graph = new ArrayList<>();
    private static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        
        for(int i = 0 ; i < N; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] way : road){
            int v1 = way[0] - 1;
            int v2 = way[1] - 1;
            int w = way[2];
            if (graph.get(v1).contains(v2)) {
                if (graph.get(v1).get(v2).cost > w) {
                    graph.get(v1).set(v2, new Edge(v2, w));
                    graph.get(v2).set(v1, new Edge(v1, w));
                }
            } else {
                graph.get(v1).add(new Edge(v2, w));
                graph.get(v2).add(new Edge(v1, w));
            }
        }
        int answer = 0;
    
        dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = 200_0000;
        }
        dist[0] = 0;
        dijkstra(0);
        
        for (int i = 0; i < N; i++) {
            if(dist[i] <= K){
                answer++;
            }
        }
        return answer;
    }
    
    private void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            for (Edge next : graph.get(now.v)) {
                if (dist[next.v] > dist[now.v] + next.cost) {
                    dist[next.v] = dist[now.v] + next.cost;
                    pq.add(new Edge(next.v, dist[next.v]));
                }
            }
        }
    }
}