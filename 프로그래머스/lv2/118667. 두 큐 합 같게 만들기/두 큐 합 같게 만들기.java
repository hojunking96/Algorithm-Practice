import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int n = queue1.length;
        long sum = 0;
        long sum1 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < n; i++){
            q1.add(queue1[i]);    
            q2.add(queue2[i]);    
            sum += queue1[i] + queue2[i];
            sum1 += queue1[i];
        }
        
        while(sum1 != sum / 2){
            if(answer > n * 4){
                return -1;
            }
            int val = 0;
            if(sum1 < sum / 2){
                val = q2.poll();
                q1.add(val);
                sum1 += val;
            }
            else if(sum1 > sum / 2){
                val = q1.poll();
                q2.add(val);
                sum1 -= val;
            }
            answer++;
        }
        return answer;
    }
}



/*
큐 두개
하나에서 빼서 반대로 넣는 작업 진행
두 큐의 값이 같아져야함
전체 값의 반을 한 쪽에다가 만들면 됨

*/