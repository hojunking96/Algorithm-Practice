class Solution {
    public int solution(int a, int b) {
        return check(a, b);
    }
    
    private int check(int a, int b){
        for(int i = 2; i <= b; i++){
            if(b % i == 0){
                if(a % i == 0 || i % 2 == 0 || i % 5 == 0){
                    continue;
                }
                return 2;
            }
        }
        return 1;
    }
}

/*
누가 큰 건지 확인,
최대공약수 구해,

*/