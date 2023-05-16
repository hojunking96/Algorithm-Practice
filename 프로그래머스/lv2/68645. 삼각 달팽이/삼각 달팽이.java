import java.util.*;

class Solution {
    
    private static int value = 1;
    private static int len;
    private static int[][] graph;
    
    public int[] solution(int n) {
        graph = new int[n][n];
        
        int x = 0;
        int y = 0;
        len = n;

        while(len > 0){
            goDown(x, y, len);
            len--;
            x += len;
            y++;

            goRight(x, y, len);
            len--;
            x--;
            y += len - 1;

            goUp(x, y, len);
            len--;
            x -= len - 1;
            y -= len;
        }
        return Arrays.stream(graph)
                    .flatMapToInt(Arrays::stream)
                    .filter(o -> o != 0).toArray();
    }
    
    private static void goDown(int x, int y, int length){
        for(int i = 0; i < length; i++){
            graph[i + x][y] = value++;
        }
    }
    
    private static void goRight(int x, int y, int length){
        for(int i = 0; i < length; i++){
            graph[x][y + i] = value++;
        }
    }
    
    private static void goUp(int x, int y, int length){
        for(int i = 0 ; i < length; i++){
            graph[x - i][y - i] = value++;
        }
    }
}

/*
걍 왼쪽으로 다 밀었다고 생각

1
2 15
3 16 14
4 17 21 13
5 18 19 20 12
6  7  8  9 10 11

*/