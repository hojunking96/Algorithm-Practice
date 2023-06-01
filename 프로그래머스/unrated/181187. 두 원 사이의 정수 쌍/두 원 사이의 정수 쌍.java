class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(long i = 1; i <= r2; i++){
            int r2Cnt = (int)Math.sqrt((long)r2 * r2 - i * i);
            
            if(i > r1){
                answer += r2Cnt + 1;
                continue;
            }
            
            double R1 = Math.sqrt((long)r1 * r1 - i * i);
            if((int)R1 == R1){
                R1--;
            }
            answer += r2Cnt - (int)R1;
        }
        return answer * 4;
    }
}

/*
각 원 별로 구한다음 빼줘
x제곱 + y제곱 = r2제곱
y

*/