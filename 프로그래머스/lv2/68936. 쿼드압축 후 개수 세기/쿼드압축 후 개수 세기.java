class Solution {
    
    private static int cnt[];
    private static boolean[] compacted;
    
    public int[] solution(int[][] arr) {
        cnt = new int[2];
        compact(arr, 0, 0, arr.length, arr.length);
        return cnt;
    }
    private static void compact(int[][]arr, int startX, int startY, int endX, int endY){
        int value = arr[startX][startY];
        boolean isSame = true;
        for(int i = startX; i < endX; i++){
            for(int j = startY; j < endY; j++){
                if(arr[i][j] != value){
                    isSame = false;
                    break;
                }
            }
        }
        if(isSame){
            cnt[value]++;
            return;
        }
        else{
            compact(arr, startX, startY, (startX + endX) / 2, (startY + endY) / 2);
            compact(arr, (startX + endX) / 2, startY, endX, (startY + endY) / 2);
            compact(arr, startX, (startY + endY) / 2, (startX + endX) / 2, endY);
            compact(arr, (startX + endX) / 2, (startY + endY) / 2, endX, endY);
        }
    }
}