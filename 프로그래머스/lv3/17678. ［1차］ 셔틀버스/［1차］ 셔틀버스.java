import java.util.*;

class Solution {
    class BusTable {
        String time;

        BusTable(int n, int t) {
            int timePassed = (n - 1) * t;
            int hour = timePassed / 60 + 9;
            int minute = timePassed % 60;
            String timeStr = "";
            if (hour <= 9) {
                timeStr = "0" + timeStr;
            }
            timeStr += hour;
            timeStr += ":";
            if (minute <= 9) {
                timeStr += 0;
            }
            timeStr += minute;
            this.time = timeStr;
        }
    }

    private List<BusTable> busArr = new ArrayList<>();

    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (String e : timetable) {
            pq.add(e);
        }

        int ptr = 0;
        for (int i = 1; i < n; i++) {
            int cnt = 0;
            BusTable busTable = new BusTable(i, t);
            while (cnt < m && !pq.isEmpty()) {
                if (pq.peek().compareTo(busTable.time) <= 0) {
                    pq.poll();
                    cnt++;
                } else {
                    break;
                }
            }
        }
        int cnt = 0;
        BusTable busTable = new BusTable(n, t);
        while (cnt < m - 1 && !pq.isEmpty()) {
            if (pq.peek().compareTo(busTable.time) <= 0) {
                pq.poll();
                cnt++;
            } else {
                break;
            }
        }
        if (pq.isEmpty()) {
            return busTable.time;
        }
        String answer = pq.poll();
        int hour = Integer.parseInt(answer.substring(0, 2));
        int minute = Integer.parseInt(answer.substring(3));
        minute--;
        if (minute == -1) {
            minute = 59;
            hour--;
        }
        String hourStr = "" + hour;
        if (hour < 10) {
            hourStr = "0" + hourStr;
        }
        String minuteStr = "" + minute;
        if (minute < 10) {
            minuteStr = "0" + minuteStr;
        }
        String timeStr = hourStr + ":" + minuteStr;
        if (timeStr.compareTo(busTable.time) > 0) {
            return busTable.time;
        }
        return timeStr;
    }
}
/*
9시부터 태울 것
한 번에 m명
t분 간격으로
n번 와

처음 왔을 때
9시 이하를 m명까지 태워
나머지는 대기

t분 후에 또 와서
9시 + t분 이하를 m명까지 태워
나머지는 또 대기

9시 + (n-1) * t 분 이게 마지막 버스임
이걸 타야되는데,
이전에 대기한 상태를 봐야돼

그러면
9시 + (n-1) * t분 이전에 온 친구들을 다 확인할건데,


*/