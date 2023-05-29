import java.util.*;

class Solution {
    
    
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static List<Integer> cnts;
    
    public int solution(int[] cards) {
        int answer = 0;
        
        int n = cards.length;
        visited = new boolean[n];
        cnts = new ArrayList<>();
        graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            graph.get(i).add(cards[i] - 1);
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                cnts.add(DFS(i, 1));
            }
        }
        
        Collections.sort(cnts, Collections.reverseOrder());
        if(cnts.size() >= 2){
            answer = cnts.get(0) * cnts.get(1);
        }
        return answer;
    }
    
    private int DFS(int n, int cnt){
        visited[n] = true;
        int next = graph.get(n).get(0);
        if(!visited[next]){
            return DFS(next, cnt + 1);
        }
        return cnt;
    }
}

/*
1~100 숫자 카드 100장
여기서 2~100 자연수 하나 n을 정해
n 이하의 숫자 카드를 준비
준비한 숫자 만큼 작은 상자 준비

그리고 게임 시작

상자에 카드 한장식 넣고 무작위 섞어
상자에 1부터 n까지 번호를 붙여

상자 하나 선택, 숫자 확인
숫자에 해당하는 상자 다시 확인
이 짓ㄱ거리를 반복

이미 열려있는 상자를 열어야할 때 종료

종료 후 열려있는 상자들은 1번 그룹임
얘네는 따로 나눠
남은 상자가 없으면 바로 종료, 0점

남은 상자가 있으면, 같은 작업 반복 -> 얘네는 2번 상자
다 하고 나면 1번 상자 개수 * 2번 상자 개수 = 게임 점수


visited 해놓고 
쭉 따라가라는 소리인가?



8 6 3 7 2 5 1 4
1번 : 8 7 1 4
6 3 2 5
2번 : 



*/