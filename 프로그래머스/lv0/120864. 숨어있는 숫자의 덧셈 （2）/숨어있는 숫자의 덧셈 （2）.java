class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String tmp = "";
        int left = 0;
        int right = 0;
        for(int i = 0 ; i < my_string.length(); i++){
            char now = my_string.charAt(i);
            if(now >= '0' && now <= '9'){
                tmp += now;
            }
            else{
                if(!tmp.equals("")){
                    answer += Integer.parseInt(tmp);                    
                }
                tmp = "";
            }
        }
        if(!tmp.equals("")){
            answer += Integer.parseInt(tmp);                    
        }
        
        return answer;
    }
}