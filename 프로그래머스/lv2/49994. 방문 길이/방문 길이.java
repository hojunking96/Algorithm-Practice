import java.util.*;

class Solution {
    
    //0 : L, 1 : D, 2 : U, 3 : R
    private static boolean[][][] visited;
    private static int[] dX = {0, 1, -1, 0};
    private static int[] dY = {-1, 0, 0, 1};
    private static Map<Character, Integer> map = new HashMap<>();
    
    public int solution(String dirs) {
        visited = new boolean[11][11][4];
        map.put('L', 0);
        map.put('D', 1);
        map.put('U', 2);
        map.put('R', 3);
        
        int nowX = 0;
        int nowY = 0;
        int totalMoveCnt = 0;
        int duplicateCnt = 0;
        char[] arr = dirs.toCharArray();
        for(char e : arr){
            int direction = map.get(e);
            int nextX = nowX + dX[direction];
            int nextY = nowY + dY[direction];
            if(nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5){
                continue;
            }
            totalMoveCnt++;
            if(visited[nowX + 5][nowY + 5][direction] || visited[nextX + 5][nextY + 5][3 - direction]){
                duplicateCnt++;
            }
            visited[nowX + 5][nowY + 5][direction]  = true;
            visited[nextX + 5][nextY +5][3 - direction] = true;
            nowX = nextX;
            nowY = nextY;
        }
        return totalMoveCnt - duplicateCnt;
    }
}