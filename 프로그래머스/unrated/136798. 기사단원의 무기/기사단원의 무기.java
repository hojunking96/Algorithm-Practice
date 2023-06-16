class Solution {
    
    private int[] cnt;
    public int solution(int number, int limit, int power) {
        int sum = 0;
        cnt = new int[number + 1];
        count(number);
        for(int i = 1; i <= number; i++){
            if(cnt[i] > limit){
                sum += power;
            }
            else{
                sum += cnt[i];
            }
        }
        return sum;
    }
    private void count(int number){
        for(int i = 1; i <= number; i++){
            for(int j = i; j <= number; j += i){
                cnt[j]++;
            }
        }
    }
}

/*
약수의 개수 = 공격력
제한 수치보다 크면 정해진 공격력 사용

약수의 개수 구하는 방법

*/