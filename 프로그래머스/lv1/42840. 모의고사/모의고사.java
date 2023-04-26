class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        int cnt = answers.length;
        for(int i = 0; i < cnt; i++){
            int ans = answers[i];
            if(p1[i % 5] == ans){
                cnt1++;
            }
            if(p2[i % 8] == ans){
                cnt2++;
            }
            if(p3[i % 10] == ans){
                cnt3++;
            }
        }
        
        if(cnt1 > cnt2){
            if(cnt1 > cnt3){
                return new int[]{1};
            }
            else if(cnt1 < cnt3){
                return new int[]{3};
            }
            else {
                return new int[]{1, 3};
            }
        }
        else if(cnt1 == cnt2){
            if(cnt1 > cnt3){
                return new int[]{1, 2};
            }
            else if(cnt1 < cnt3){
                return new int[]{3};
            }
            else{
                return new int[]{1, 2, 3};
            }
        }
        else{
            if(cnt2 > cnt3){
                return new int[]{2};
            }
            else if(cnt2 < cnt3){
                return new int[]{3};
            }
            else {
                return new int[]{2, 3};
            }
        }
    }
}