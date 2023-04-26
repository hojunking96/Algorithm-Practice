class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        for(int i = 0; i < strArr.length; i++){
            String str = strArr[i];
            if(i % 2 == 0){
                str = str.toLowerCase();
            }
            else{
                str = str.toUpperCase();
            }
            answer[i] = str;
        }
        return answer;
    }
}