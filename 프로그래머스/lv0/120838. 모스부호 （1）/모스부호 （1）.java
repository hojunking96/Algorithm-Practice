class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".","..-.",
                "--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",
                ".--","-..-","-.--","--.."
                          };
        String[]letters = letter.split(" ");
        for(String e : letters){
            for(int i=0;i<morse.length;i++){
                if(morse[i].equals(e)){
                    answer+=(char)('a'+i);
                }
            }
        }
        return answer;
    }
}