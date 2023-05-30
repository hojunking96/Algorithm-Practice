class Solution {

    private int cnt = 0;

    public int solution(int n) {
        boolean[][] cant = new boolean[n][n];
        search(0, n, cant);
        return cnt;
    }

    private void search(int depth, int n, boolean[][] cant){
        if(depth == n){
            for(int i = 0; i < n; i++){
                if(!cant[n - 1][i]){
                    cnt++;
                }
            }
            return;
        }
        for(int i = 0; i < n; i++){
            boolean[][] newCant = new boolean[n][n];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    newCant[j][k] = cant[j][k];
                }
            }
            if(!newCant[depth][i]){
                for(int j = 1; j < n - depth; j++){
                    if(i >= j){
                        newCant[depth + j][i - j] = true;
                    }
                    newCant[depth + j][i] = true;
                    if(i + j < n){
                        newCant[depth + j][i + j] = true;
                    }
                }
                search(depth + 1, n, newCant);
            }
        }
    }
}

/*
내가볼 때 이거 꿀팁 시간복잡도 체크 가능할듯?
        for(int i = 0 ; i < n; i++){
             for(int j = 0 ; j < n; j++){
                 for(int t = 0; t < n; t++){
                    answer = 1;
                }   
            }   
        }
*/