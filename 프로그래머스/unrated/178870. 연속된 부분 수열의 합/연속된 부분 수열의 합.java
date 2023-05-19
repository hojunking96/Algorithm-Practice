class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        while(right < sequence.length && left <= right){
            if(sum == k){
                if (right - left < min) {
                    min = right - left;
                    answer[0] = left;
                    answer[1] = right;
                } else {
                    sum -= sequence[left];
                    left++;
                }
            }
            else if(sum > k){
                sum -= sequence[left];
                left++;
            }
            else{
                if(right >= sequence.length - 1){
                    break;
                }
                sum += sequence[right + 1];
                right++;
            }
        }
        return answer;
    }
}