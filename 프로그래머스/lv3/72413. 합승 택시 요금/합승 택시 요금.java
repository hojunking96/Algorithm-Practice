class Solution {
    
    private int[][] graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j){
                    graph[i][j] = 0;
                }
                else{
                    graph[i][j] = 20_000_000;
                }
            }
        }
        for(int[]fare : fares){
            graph[fare[0] - 1][fare[1] - 1] = fare[2];
            graph[fare[1] - 1][fare[0] - 1] = fare[2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n ; i++){
            min = Math.min(min, graph[i][a - 1] + graph[i][b - 1] + graph[s - 1][i]);
        }
        return min;
    }
}