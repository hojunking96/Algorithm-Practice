class Solution {
    
    private static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        search(dungeons, 0, k, visited);
        return max;
    }
    private static void search(int[][]dungeons, int cnt, int nowP, boolean[] visited){
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && nowP >= dungeons[i][0]){
                visited[i] = true;
                search(dungeons, cnt + 1, nowP - dungeons[i][1], visited);
                visited[i] = false;
            }
        }
        
        if(max < cnt){
            max = cnt;
        }
        return;
    }
}