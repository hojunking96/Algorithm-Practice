class Solution {
    public String[] solution(String[] picture, int k) {
        int x = picture.length;
        int y = picture[0].length();
        String[] answer = new String[x * k];
        int b = 0;
        for(int i = 0; i < x; i++){
            answer[b] = "";
            for(int j = 0 ; j < y; j++){
                for(int l = 0; l < k; l++){
                    answer[b] += picture[i].charAt(j);    
                }
            }
            for(int a = 0; a < k; a++){
                if(b + 1 >= x * k){
                    break;
                }
                answer[b + 1] = answer[b++];
            }
            
        }
        return answer;
    }
}