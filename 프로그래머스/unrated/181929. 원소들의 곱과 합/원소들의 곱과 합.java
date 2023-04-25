class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int m = 1;
        int s = 0;
        for(int i = 0; i < num_list.length; i++){
            m *= num_list[i];
            s += num_list[i];
        }
        return m < s * s ? 1 : 0;
    }
}