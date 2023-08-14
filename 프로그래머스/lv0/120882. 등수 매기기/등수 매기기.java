class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        int m = score[0].length;
        int[] answer = new int[n];
        double[] avgs = new double[score.length];
        for(int i = 0; i < score.length; i++){
            double avg = 0;
            for(int e : score[i]){
                avg += e;
            }
            avgs[i] = avg / m;
        }
        for(int i = 0 ; i < n; i++){
            int rank = 1;
            for(int j = 0; j < n; j++){
                if(avgs[j] > avgs[i]){
                    rank++;
                }
            }
            answer[i] = rank;
        }
        
        return answer;
    }
}