import java.util.*;

class Solution {
    
    private int[] dX = {-1, 0, 1, 0};
    private int[] dY = {0, -1, 0, 1};
    private int distance;
    private int dir;
    private int x = 0;
    private int y = 0;
    
    public int[] solution(String[] park, String[] routes) {

        for(int i = 0; i < park.length; i++){
            String line = park[i];
            if(line.contains("S")){
                x = i;
                y = line.indexOf('S');
                break;
            }
        }
        
        
        Map<String, Integer> map = new HashMap<>();
        map.put("N", 0);
        map.put("W", 1);
        map.put("S", 2);
        map.put("E", 3);
        
        
        for(String route : routes){
            String[] tmp = route.split(" ");
            String direction = tmp[0];
            distance = Integer.parseInt(tmp[1]);
            dir = map.get(direction);
            int nextX = x;
            int nextY = y;
            if(outOfRange(park.length, park[0].length())){
                continue;
            }
            
            boolean cantgo = false;
            for(int i = 0; i < distance; i++){
                nextX += dX[dir];
                nextY += dY[dir];
                if(park[nextX].charAt(nextY) == 'X'){
                    cantgo = true;
                    break;
                }
            }
            if(cantgo){
                continue;
            }
            x = nextX;
            y = nextY;
        }
        return new int[]{x, y};
    }
    private boolean outOfRange(int limitX, int limitY){
        return x + dX[dir] * distance >= limitX ||
               y + dY[dir] * distance >= limitY ||
               x + dX[dir] * distance < 0 ||
               y + dY[dir] * distance < 0;
    }
}