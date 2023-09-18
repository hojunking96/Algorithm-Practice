class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            answer[i] = convert(n, arr1[i], arr2[i]);
        }
        return answer;
    }
    
    private String convert(int n, int num1, int num2){
        String tmp = "";
        for(int i = 0; i < n; i++){
            if(num1 % 2 == 0 && num2 % 2 == 0){
                tmp = " " + tmp;
            }
            else{
                tmp = "#" + tmp;
            }
            num1 /= 2;
            num2 /= 2;
        }
        return tmp;
    }
}