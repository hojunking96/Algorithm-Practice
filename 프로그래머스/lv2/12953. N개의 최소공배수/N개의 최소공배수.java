class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++){
            answer = LCM(answer, arr[i]);
        }
        return answer;
    }
    private static int LCM(int a, int b){
        return a * b / GCD(a, b);
    }
    private static int GCD(int a, int b){
        if(b == 0){
            return a;
        }
        return GCD(b, a % b);
    }
}