class Solution {
    public String solution(int n, int t, int m, int p) {
        String str = "";
        for(int i = 0 ; i < m * t + p; i++){
            str += Integer.toString(i, n);
        }
        String answer = "";
        for(int i = 0; i < t; i ++){
            answer += str.charAt(m * i + p - 1);
        }
        return answer.toUpperCase();
    }
}


/*

0 1  10  11 100

*/