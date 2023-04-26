class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int column = arr2[0].length;
        int mid = arr2.length;
        int[][] answer = new int[row][column];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                for(int k = 0; k < mid; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }       
        }
        
        return answer;
    }
}

/*
 1 4    3 3         (0,0)*(0,0) + (0,1)*(1,0) => (0,0)
 3 2    3 3         (0,0)*(0,1) + (1,0)*(1,1) => (0,1)
 4 1
*/