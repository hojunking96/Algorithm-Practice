class Solution {
    
    private static boolean[] visited;
    private static int cnt;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        cnt = words.length + 1;
        
        DFS(0, words.length, begin, target, words);
        if(cnt == words.length + 1){
            return 0;
        }
        return cnt;
    }
    private static void DFS(int depth, int n, String now, String target, String[] words){
        if(now.equals(target)){
            if(cnt > depth){
                cnt = depth;
            }
        }
        if(depth == n + 1){
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i] && oneWordDifferent(now, words[i])){
                visited[i] = true;
                DFS(depth + 1, n, words[i], target, words);
                visited[i] = false;
            }
        }
        
    }
    private static boolean oneWordDifferent(String now, String next){
        int cnt = 0;
        for(int i = 0 ; i < now.length(); i++){
            if(now.charAt(i) != next.charAt(i)){
                cnt++;
            }
            if(cnt >= 2){
                return false;
            }
        }
        return true;
    }
}