class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i = 1; i <= yellow; i++){
            int j = yellow / i;
            if(yellow % i != 0){
                continue;
            }
            if(i * 2 + j * 2 + 4 == brown){
                return new int[]{Math.max(i, j) + 2, Math.min(i, j) + 2};
            }
        }
        return null;
    }
}