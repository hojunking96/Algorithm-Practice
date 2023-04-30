class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] strArr = my_string.split(" ");

        boolean isPlus = true;
        
        int sum = 0;        
        for(int i = 0 ; i < strArr.length; i++){
            String str = strArr[i];
            if(str.equals("+")){
                isPlus = true;
            }
            else if(str.equals("-")){
                isPlus = false;
            }
            else{
                if(isPlus){
                    sum += Integer.parseInt(str);
                }
                else{
                    sum -= Integer.parseInt(str);
                }
            }
        }
        return sum;
    }
}