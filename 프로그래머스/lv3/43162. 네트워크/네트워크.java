class Solution {
    private static boolean[]visited;
    public int solution(int n, int[][] computers) {
        int cnt=0;
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                DFS(n,computers,i);
                visited[i]=true;
                cnt++;
            }
        }
        return cnt;
    }
    private static void DFS(int n,int[][]computers,int start){
        visited[start]=true;
        for(int i=0;i<n;i++){
            if(visited[i])
                continue;
            if(start!=i && computers[start][i]==1){
                DFS(n,computers,i);
            }
        }
    }
}