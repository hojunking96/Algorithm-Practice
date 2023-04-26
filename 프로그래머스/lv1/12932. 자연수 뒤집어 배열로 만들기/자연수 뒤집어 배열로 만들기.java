class Solution {
    public int[] solution(long n) {
        char[] tmp = ("" + n).toCharArray();
        int[] answer = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++){
            answer[i] = tmp[tmp.length - i - 1] - '0';
        }
        return answer;
    }
}