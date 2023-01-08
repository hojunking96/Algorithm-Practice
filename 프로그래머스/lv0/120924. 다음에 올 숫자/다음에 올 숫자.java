class Solution {
    public int solution(int[] common) {
         int answer = 0;
        int d = common[1] - common[0];
        boolean isPlus = true;
        for (int i = 0; i < common.length - 1; i++) {
            if (common[i + 1] - common[i] != d){
                isPlus = false;
                break;
            }
        }
        if (isPlus) {
            answer = common[common.length - 1] + d;
        }
        else {
            d = common[1] / common[0];
            answer = common[common.length - 1] * d;
        }

        return answer;
    }
}