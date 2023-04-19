import java.util.*;

class Solution {
    
    private static Set<String> history = new HashSet<>();
    
    public int[] solution(int n, String[] words) {
        int turn = 0;
        int roundCnt = 1;
        String word = words[turn++];
        history.add(word);
        String prev = word;
        while(turn < words.length){
            if(turn % n == 0){
                roundCnt++;
            }
            word = words[turn];
            if(history.contains(word)){
                break;
            }
            if(prev.charAt(prev.length() - 1) != word.charAt(0)){
                break;
            }
            prev = word;
            history.add(word);
            turn++;
        }
        if(turn == words.length){
            return new int[]{0, 0};
        }
        return new int[]{turn % n + 1, roundCnt};
    }
}