import java.util.*;

class Solution {
    
    private static Map<String, Integer> ranks;
    private static String[] letters = {"A", "E", "I", "O", "U"};
    private static int rank = 0;
    
    public int solution(String word) {
        ranks = new HashMap<>();
        makeRank("");
        return ranks.get(word);
    }
    
    private static void makeRank(String word){
        if(word.length() >= 5){
            return;
        }
        for(int i = 0; i < 5; i++){
            word += letters[i];
            rank++;
            ranks.put(word, rank);
            makeRank(word);
            word = word.substring(0, word.length() - 1);
        }
    }
}