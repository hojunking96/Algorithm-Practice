import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static Queue<Integer> dayNeed;
    public static int N;
    public static int[] temp;
    
    public int[] solution(int[] progresses, int[] speeds) {
       int[] answer = {};
        N = progresses.length;
        temp = new int[N];
        dayNeed = new LinkedList<>();
        calculate(progresses, speeds);
        count();
        int length = temp.length;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                length = i;
                break;
            }
        }
        answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = temp[i];
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static void calculate(int[] progresses, int[] speeds) {
        int N = progresses.length;
        for (int i = 0; i < N; i++) {
            if ((100 - progresses[i]) % speeds[i] != 0) {
                dayNeed.add((100 - progresses[i]) / speeds[i] + 1);
            } else
                dayNeed.add((100 - progresses[i]) / speeds[i]);
        }
    }

    public static void count() {
        int i = 0;
        while (!dayNeed.isEmpty()) {
            int cnt = 0;
            int tmp = dayNeed.peek();
            while (!dayNeed.isEmpty() && dayNeed.peek() <= tmp) {
                cnt++;
                dayNeed.poll();
            }
            if (cnt == 0)
                break;
            temp[i] = cnt;
            i++;
        }
    }
}