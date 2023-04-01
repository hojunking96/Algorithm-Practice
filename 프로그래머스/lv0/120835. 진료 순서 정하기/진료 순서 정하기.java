class Solution {
    public int[] solution(int[] emergency) {
        int size = emergency.length;
        int[]answer = new int[size];
        for(int i=0;i<size;i++){
            int cnt=1;
            for(int j=0;j<size;j++){
                if(emergency[i]<emergency[j]){
                    cnt++;
                }
            }
            answer[i]=cnt;
        }
        return answer;
    }
}