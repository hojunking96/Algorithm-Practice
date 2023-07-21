class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(char e : my_string.toCharArray()){
            if(e >= 'a' && e <= 'z'){
                answer[(int)((e - 'a') + 26)]++;
            }
            else{
                answer[(int)(e - 'A')]++;
            }
        }
        return answer;
    }
}