class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int A_GCD = arrayA[0];
        for(int i = 1; i < arrayA.length; i++){
            A_GCD = GCD(A_GCD, arrayA[i]);
        }
        
        int B_GCD = arrayB[0];
        for(int i = 1; i < arrayB.length; i++){
            B_GCD = GCD(B_GCD, arrayB[i]);
        }
        
        if(qualified(arrayB, A_GCD)){
            answer = A_GCD;
        }
        
        if(qualified(arrayA, B_GCD)){
            if(answer == 0){
                answer = B_GCD;
            }
            else{
                answer = Math.max(A_GCD, B_GCD);
            }
        }
        return answer;
    }
    
    private boolean qualified(int[] arr, int gcd){
        for(int e : arr){
            if(e % gcd == 0){
                return false;
            }
        }
        return true;
    }
    
    private int GCD(int a, int b){
        if(a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }
}

/*
1. 공약수들을 구해서 내림차순 정렬해
    그냥 최대공약수를 구하면 된다는데?
    최대공약수로는 안되는데 최대공약수가 아닌 공약수로 조건이 만족하는 경우는 없나?
2. 하나씩 조건에 해당하는지 비교, 해당할 때 저장
3. 배열을 반대로 바꿔서도 값 저장
4. 두 값 중 최대 값을 출력



*/