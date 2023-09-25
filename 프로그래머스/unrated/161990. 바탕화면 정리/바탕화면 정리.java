class Solution {
    
    private int x1 = Integer.MAX_VALUE;
    private int y1 = Integer.MAX_VALUE;
    private int x2 = 0;
    private int y2 = 0;
    
    
    public int[] solution(String[] wallpaper) {
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    x1 = Math.min(x1, j);
                    y1 = Math.min(y1, i);
                    x2 = Math.max(x2, j + 1);
                    y2 = Math.max(y2, i + 1);
                }
            }
        }
        return new int[]{y1, x1, y2, x2};
    }
}


/*

*/