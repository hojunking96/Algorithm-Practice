class Solution {
    public int[][] solution(int[] num_list, int n) {
        
        int[][] answer = new int[num_list.length/n][n];
        int cnt1 = 0;
        int cnt2 = 0;
        
        for(int i=0;i<num_list.length;i++){
            answer[cnt1][cnt2]=num_list[i];
            cnt2++;
            if(cnt2==n){
                cnt1++;
                cnt2=0;
            }
        }
    
        return answer;
    }
}