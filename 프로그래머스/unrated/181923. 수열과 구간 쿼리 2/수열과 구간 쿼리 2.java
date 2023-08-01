class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int ptr = 0;
        for(int i = 0; i < queries.length; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            
            int min = 2_000_000;
            for(int j = s; j <= e; j++){
                if(arr[j] > k){
                    min = Math.min(min, arr[j]);
                }
            }
            if(min == 2_000_000){
                answer[ptr] = -1;
            }
            else{
                answer[ptr] = min;
            }
            ptr++;
        }
        return answer;
    }
}