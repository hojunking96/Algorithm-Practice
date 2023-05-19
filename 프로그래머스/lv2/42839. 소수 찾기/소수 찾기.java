import java.util.*;

class Solution {
    
    private static Set<Integer> set = new HashSet<>();
    private static boolean[] visited;
    private static int n;
    private static int max = Integer.MIN_VALUE;
    private static boolean[] isNotPrime;
        
    public int solution(String numbers) {
        n = numbers.length();
        visited = new boolean[n];
        
        backTracking(0, "", numbers);
        isNotPrime = new boolean[max + 1];
        Eratostenes();
        
        int cnt = 0;
        for(int k : set){
            if(!isNotPrime[k]){
                cnt++;
            }
        }
        return cnt;
    }
    
    private static void backTracking(int depth, String k, String numbers){
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                String newStr = k + numbers.charAt(i);
                int value = Integer.parseInt(newStr);
                set.add(value);
                max = Math.max(max, value);
                visited[i] = true;
                backTracking(depth + 1, newStr, numbers);
                visited[i] = false;
            }
        }
    }
    
    private static void Eratostenes(){
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        
        for(int i = 2; i <= max / 2; i++){
            if(!isNotPrime[i]){
                for(int j = i + i; j <= max; j += i){
                    isNotPrime[j] = true;
                }
            }
        }
    }
}