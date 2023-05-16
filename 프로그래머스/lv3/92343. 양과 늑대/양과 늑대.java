import java.util.*;

class Solution {
    
    private static List<Integer>[] graph;
    private static int max = 0;
    
    public int solution(int[] info, int[][] edges) {
        int totalCnt = info.length;
        graph = new List[totalCnt];
        
        for(int i = 0; i < totalCnt; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
        }
        List<Integer> nexts = new ArrayList<>();
        DFS(0, info, 0, 0, nexts);
        return max;
    }
    private static void DFS(int now, int[] info, int sheep, int wolf, List<Integer> nexts){
        if(info[now] == 0){
            sheep++;
        }
        else{
            wolf++;
        }
        if(sheep <= wolf){
            return;
        }
        if(max < sheep){
            max = sheep;
        }
        List<Integer> list = new ArrayList<>();
        for(int e : nexts){
            if(e != now){
                list.add(e);
            }
        }
        for(int e : graph[now]){
            list.add(e);
        }
        for(int e : list){
            DFS(e, info, sheep, wolf, list);
        }
    }
}
