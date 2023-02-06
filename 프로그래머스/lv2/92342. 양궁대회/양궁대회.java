class Solution {
   
    public static int max = -1;
    public static int[] Lion;

    public int[] solution(int n, int[] info) {
        Lion = new int[11];
        int[] tmp = new int[11];
        dfs(info, tmp, n, 0, 10);
        int sum = 0;
        for (int e : Lion) {
            sum += e;
        }
        if (sum == 0) {
            return new int[]{-1};
        }
        return Lion;
    }

    public static void dfs(int[] info, int[] tmp, int n, int depth, int start) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                int[] arr = convertLion(tmp, n);
//                int[] arr = {0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0};
                int sum = calculate(info, arr);
                if (max < sum) {
                    max = sum;
                    Lion = arr;
                }
            }
            return;
        }
        for (int i = start; i >= 0; i--) {
            tmp[depth] = i;
            dfs(info, tmp, n, depth + 1, i);
        }
    }

    public static int[] convertLion(int[] arr, int n) {
        int[] lion = new int[11];
        for (int i = 0; i < n; i++) {
            lion[arr[i]]++;
        }
        return lion;
    }

    public static int calculate(int[] info, int[] lion) {
        int sumPeach = 0;
        int sumLion = 0;
        for (int i = 0; i < 10; i++) {
            if (info[i] < lion[i]) {
                sumLion += (10 - i);
            } else {
                if (info[i] == 0) {
                    continue;
                }
                sumPeach += (10 - i);
            }
        }
        int diff = sumLion - sumPeach;
        if (diff > 0) {
            return diff;
        }
        return -1;
    }
}