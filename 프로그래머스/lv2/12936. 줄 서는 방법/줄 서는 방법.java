import java.util.*;

class Solution {
    
    private static long cnt;
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            arr.add(i);
        }
        
        long fac = factorial(n);
        for(int i = 0; i < n - 1; i++){
            fac /= (n - i);
            int index;
            if (k != 0) {
                index = (int) ((k - 1) / fac) + 1;
                answer[i] = arr.get(index);
            } else {
                index = arr.size() - 1;
                answer[i] = arr.get(index);
            }
            arr.remove(index);
            k %= fac;
        }
        answer[n - 1] = arr.get(1);
        
        
        return answer;
    }
    
    private static long factorial(int n){
        long result = 1;
        for(long i = 2; i <= n; i++){
            result *= i;
        }
        return result;
    }
}

/*

전체 가지 수는 n! 개
(n-1)!개로 나눈 몫이 자릿 수의 인덱스



만약 n개 중에서 (1, 2, ..., n)
첫 번째가 k이면
(k - 1) * (n - 1)!만큼을 의미한다.
arr에 저장해놓고 삭제하면서 이것 보다 작은것들의 개수를 계산해

그러면 거꾸로
(n-1)!을 계산한 다음에 이걸로 k를 나눠봐
몫이 있으면 + 1

*/