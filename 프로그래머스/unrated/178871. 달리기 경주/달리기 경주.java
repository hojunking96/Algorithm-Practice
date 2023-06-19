import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap<>();
        int rank = 1;
        for(String player : players){
            map.put(player, rank);
            answer[rank - 1] = player;
            rank++;
        }
        for(String calling : callings){
            int now = map.get(calling);
            String nextPlayer = answer[now - 2];
            answer[now - 2] = answer[now - 1];
            answer[now - 1] = nextPlayer;
            map.put(calling, now - 1);
            map.put(nextPlayer, now);
        }
        return answer;
    }
}
/*
["mumu", "soe", "poe", "kai", "mine"]
1 2 3 4 5
mumu kai soe poe mine
mumu kai mine soe poe

*/