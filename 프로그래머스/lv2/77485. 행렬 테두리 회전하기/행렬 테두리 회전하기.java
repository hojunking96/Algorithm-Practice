import java.util.ArrayList;
import java.util.List;

class Solution {
    
    static class Node {
        int x;
        int y;
        int number;

        public Node(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }

    public static int[][] graph;
    public static List<Node> nodes;
    
    public int[] solution(int rows, int columns, int[][] queries) {
    int[] answer = new int[queries.length];
        graph = new int[rows][columns];
        int k = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                graph[i][j] = k++;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            nodes = new ArrayList<>();
            makeList(queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
            int start = graph[queries[i][0]][queries[i][1] - 1];
            answer[i] = change(start);
        }
        return answer;
    }


    public static void makeList(int startX, int startY, int endX, int endY) {
        for (int i = startY; i <= endY; i++) {
            nodes.add(new Node(startX, i, graph[startX][i]));
        }
        for (int i = startX + 1; i <= endX; i++) {
            nodes.add(new Node(i, endY, graph[i][endY]));
        }
        for (int i = endY - 1; i >= startY; i--) {
            nodes.add(new Node(endX, i, graph[endX][i]));
        }
        for (int i = endX - 1; i >= startX; i--) {
            nodes.add(new Node(i, startY, graph[i][startY]));
        }
    }

    public static int change(int start) {
        int min = Integer.MAX_VALUE;
        for (int i = nodes.size() - 1; i >= 1; i--) {
            graph[nodes.get(i).x][nodes.get(i).y]
                    = nodes.get(i - 1).number;
            min = Math.min(min, nodes.get(i - 1).number);
        }
        return Math.min(min, start);
    }

}