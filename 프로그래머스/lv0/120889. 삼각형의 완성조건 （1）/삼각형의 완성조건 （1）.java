class Solution {
    public int solution(int[] sides) {
        int max = Math.max(sides[0],sides[1]);
        max=Math.max(max,sides[2]);
        int maxIndex=0;
        for(int i=0;i<3;i++){
            if(sides[i]==max){
                maxIndex=i;
                break;
            }
        }
        int sum=0;
        for(int e : sides){
            sum+=e;
        }
        sum-=max;
        if(sum>max){
            return 1;
        }
        else{
            return 2;
        }
    }
}