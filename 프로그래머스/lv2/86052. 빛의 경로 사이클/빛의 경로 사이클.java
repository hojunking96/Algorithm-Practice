import java.util.*;

class Solution {

    private int n, m;
    private boolean[][][] visited;

    public int[] solution(String[] grid) {
        n = grid.length;
        m = grid[0].length();
        visited = new boolean[n][m][4];

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int turn = 0; turn < 4; turn++) {
                    if (visited[i][j][turn]) {
                        continue;
                    }
                    int length = DFS(i, j, turn, 0, grid);
                    answer.add(length);
                }
            }
        }
        return answer.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int DFS(int x, int y, int dir, int length, String[] grid) {
        while(!visited[x][y][dir]){
            visited[x][y][dir] = true;
            length++;
            int[] point = calcPoint(x, y, dir);
            int newDir = calcDirection(point[0], point[1], dir, grid);
            x = point[0];
            y = point[1];
            dir = newDir;
        }
        return length;
    }
    
    private int[] calcPoint(int x, int y, int dir){
        if (dir == 0) {
            if (x == 0) {
                x = n;
            }
            x--;
        } else if (dir == 1) {
            if (y == m - 1) {
                y = -1;
            }
            y++;
        } else if (dir == 2) {
            if (x == n - 1) {
                x = -1;
            }
            x++;
        } else {
            if (y == 0) {
                y = m;
            }
            y--;
        }
        return new int[]{x, y};
    }

    private int calcDirection(int x, int y, int dir, String[] grid) {
        if (grid[x].charAt(y) == 'L') {
            return (dir + 3) % 4;
        }
        if (grid[x].charAt(y) == 'R') {
            return (dir + 1) % 4;
        }
        return dir;
    }
}

/*
dir = 0 -> 위쪽
dir = 1 -> 오른쪽
dir = 2 -> 아래쪽
dir = 3 -> 왼쪽
*/