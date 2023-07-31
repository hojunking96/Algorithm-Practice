class Solution {
    public int[][] solution(int[][] arr) {
        int row = arr.length;
        int column = arr[0].length;

        int[][] answer;
        
        if(row > column){
            answer = new int[row][row];
            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    answer[i][j] = arr[i][j];
                }
                for(int j = column; j < row; j++){
                    answer[i][j] = 0;
                }
            }
        }
        else if(row < column){
            answer = new int[column][column];
            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    answer[i][j] = arr[i][j];
                }
            }
            for(int i = row; i < column; i++){
                for(int j = 0; j < column; j++){
                    answer[i][j] = 0;
                }
            }
        }
        else{
            return arr;
        }
        return answer;
    }
}