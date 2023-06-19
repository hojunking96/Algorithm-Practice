class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] speakableStr = new String[]{"ma", "aya", "woo", "ye"};
        String[] str = new String[]{"mama", "ayaaya", "woowoo", "yeye"};
        for(String e : babbling){
            for(int i = 0; i < 4; i++){
                e = e.replaceAll(str[i], "x");
            }
            for(int i = 0; i < 4; i++){
                e = e.replaceAll(speakableStr[i], "A");
            }
            e = e.replaceAll("A","");
            if(e.equals("")){
                answer++;
            }
        }
        return answer;
    }
}
/*
ma ye
aya
*/