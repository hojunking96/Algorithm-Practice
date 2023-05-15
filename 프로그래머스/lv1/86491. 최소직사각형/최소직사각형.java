class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxmax = 0;
        int minmin = 0;
        for(int[] size : sizes){
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);
            if(max > maxmax){
                maxmax = max;
            }
            if(min > minmin){
                minmin = min;
            }
        }
        return maxmax * minmin;
    }
}