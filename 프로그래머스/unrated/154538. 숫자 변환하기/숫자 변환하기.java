import java.util.*;

class Solution {
    
    private static int[] cnt;
    
    public int solution(int x, int y, int n) {
        cnt = new int[1_000_001];
        doCalc(x, y, n);
        if(cnt[y] == 0 && y != x){
            return -1;
        }
        return cnt[y];
    }
    
    private static void doCalc(int x, int y, int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while(!q.isEmpty()){
            int now = q.poll();
            if(now == y){
                return;
            }
            int next = now * 3;
            if(next <= y){                
                if(cnt[next] == 0){
                    cnt[next] = cnt[now] + 1;
                    q.add(next);
                }
            }
            next = now * 2;
            if(next <= y){ 
                if(cnt[next] == 0){
                    cnt[next] = cnt[now] + 1;
                    q.add(next);
                }
            } 
            next = now + n;
            if(next <= y){                
                if(cnt[next] == 0){
                    cnt[next] = cnt[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}