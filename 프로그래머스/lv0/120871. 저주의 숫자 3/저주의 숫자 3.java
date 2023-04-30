class Solution {
    public int solution(int n) {
        int[] num = new int[101];
        int cnt = 1;
        for(int i = 1; i <= n; i++){
            while(cnt % 3 == 0 || ("" + cnt).contains("3")){
                cnt++;
            }
            num[i] = cnt;
            cnt++;
        }
        return num[n];
    }
}