class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)end - (int)begin + 1];
        int k = 0;
        for(int i = 0; i <= end - begin; i++){
            int value = findMaxDividor(i + begin);
            if(i + begin == 1){
                answer[i] = 0;
                continue;
            }
            answer[i] = value;
        }
        return answer;
    }
    private int findMaxDividor(long e){
        int value = 1;
        for(int i = 2; i <= (int)Math.sqrt(e); i++){
            int k = (int)e / i;
            if((int)e % i == 0){
                if(k > 10_000_000){
                    value = Math.max(value, i);
                    continue;
                }
                value = Math.max(value, k);
            }
        }
        return value;
    }
}

/*

1 n
2 n/2
3 n/3
4 n/4 
...
root n root n


[begin, end] = [100000014, 100000016] 를 테스트했을 때,
[1, 1, 6250001]이 아닌 [6, 5, 6250001]
n * i 에 블록 넣음
기존에 있던 블록을 바꿔끼움
초기 : 1 2 3 4 5 6 7 8 9 10
1 :   0 1 1 1 1 1 1 1 1 1
2 :   0 1 1 2 1 2 1 2 1 2
3 :   0 1 1 2 1 3 1 2 3 2
4 :   0 1 1 2 1 3 1 4 3 2
5 :   0 1 1 2 1 3 1 4 3 5
1_000_000_000 까지, 1 ~ 1_000_000_000 의 블록
i번째 : i의 약수 중 자신이 아닌 것 중에 제일 큰 것
1. i의 제곱근 부터 아래로 내려가볼까
2. 아니면 처음부터 에라토스테네스의 체 처럼 진행할까
    - 메모리 초과난다.



*/