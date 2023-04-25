class Solution {
    public int solution(int[] num_list, int n) {
        for(int e : num_list){
            if(e == n){
                return 1;
            }
        }
        return 0;
    }
}