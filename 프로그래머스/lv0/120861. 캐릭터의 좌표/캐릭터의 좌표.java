class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        int xLimit = board[0] / 2;
        int yLimit = board[1] / 2;
        
        if(keyinput.length == 0){
            return new int[]{0, 0};
        }
        for(String e : keyinput){
            if(e.equals("up")){
                if(yLimit > y){
                    y++;
                }
            }
            else if(e.equals("down")){
                if(-yLimit < y){
                    y--;
                }
            }
            else if(e.equals("right")){
                if(xLimit > x){
                    x++;
                }            
            }
            else {
                if(-xLimit < x){
                    x--;
                }            
            }
        }
        return new int[]{x, y};
    }
}