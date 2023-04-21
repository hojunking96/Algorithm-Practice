class Solution {
    public int[] solution(int[] arr) {
        int left = -1;
        int right = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2){
                if(left == -1){
                    left = i;
                }
                right = i;
            }
        }
        if(left == -1){
            return new int[]{-1};
        }
        int[] answer = new int[right - left + 1];
        for(int i = left, j = 0; i <= right; i++, j++){
            answer[j] = arr[i];
        }
        return answer;
    }
}