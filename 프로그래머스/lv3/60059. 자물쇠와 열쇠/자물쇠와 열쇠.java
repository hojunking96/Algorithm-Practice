class Solution {

    private int n;
    private int m;

    public boolean solution(int[][] key, int[][] lock) {
        n = key.length;
        m = lock.length;

        for (int turn = 0; turn < 4; turn++) {
            for (int i = 0; i <= n + m - 2; i++) {
                for (int j = 0; j <= n + m - 2; j++) {
                    if (unLock(key, lock, i, j)) {
                        return true;
                    }
                }
            }
            key = turn(key);
        }
        return false;
    }

    private int[][] turn(int[][] key) {
        int len = key.length;
        int[][] turnedKey = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                turnedKey[i][j] = key[len - j - 1][i];
            }
        }
        return turnedKey;
    }

    private boolean unLock(int[][] key, int[][] lock, int keyStartX, int keyStartY) {
        int lockStart = n - 1;
        int lockEnd = n + m - 2;

        int[][] board = new int[n + n + m - 2][n + n + m - 2];
        for (int i = lockStart; i <= lockEnd; i++) {
            for (int j = lockStart; j <= lockEnd; j++) {
                board[i][j] = lock[i - lockStart][j - lockStart];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i + keyStartX][j + keyStartY] = board[i + keyStartX][j + keyStartY] + key[i][j];
            }
        }
        for (int i = lockStart; i <= lockEnd; i++) {
            for (int j = lockStart; j <= lockEnd; j++) {
                if (board[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}