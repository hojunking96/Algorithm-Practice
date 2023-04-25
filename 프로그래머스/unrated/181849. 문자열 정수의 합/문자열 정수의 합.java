class Solution {
    public int solution(String num_str) {
        char[] arr = num_str.toCharArray();
        int answer = 0;
        for(int i = 0; i < arr.length; i++){
            answer += arr[i] - '0';
        }
        return answer;
    }
}