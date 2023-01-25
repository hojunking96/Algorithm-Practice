import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
         int len = privacies.length;
        int[] answer = {};
        int[] tmpAnswer = new int[len];
        int ptr = 0;
        HashMap<Character, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            termsMap.put(terms[i].charAt(0), Integer.parseInt(terms[i].substring(2)));
        }
        for (int i = 0; i < len; i++) {
            char type = privacies[i].charAt(11);
            int duration = termsMap.get(type);
            String deadLine = calculateDate(privacies[i].substring(0, 11), duration);
            if (isExpired(today, deadLine)) {
                tmpAnswer[ptr] = i + 1;
                ptr++;
            }
        }
        answer = new int[ptr];
        for (int i = 0; i < ptr; i++) {
            answer[i] = tmpAnswer[i];
        }
        return answer;
    }
      public static String calculateDate(String date, int duration) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        month += duration;
        while (month > 12) {
            month -= 12;
            year++;
        }
        return year + "." + month + "." + day;
    }

    public static boolean isExpired(String today, String deadLine) {
        String[] todayArr = today.split("\\.");
        String[] deadLineArr = deadLine.split("\\.");
        int todayY = Integer.parseInt(todayArr[0]);
        int todayM = Integer.parseInt(todayArr[1]);
        int todayD = Integer.parseInt(todayArr[2]);
        int deadLineY = Integer.parseInt(deadLineArr[0]);
        int deadLineM = Integer.parseInt(deadLineArr[1]);
        int deadLineD = Integer.parseInt(deadLineArr[2]);

        if (todayY > deadLineY)
            return true;
        if (todayY == deadLineY) {
            if (todayM > deadLineM)
                return true;
            if (todayM == deadLineM) {
                if (todayD >= deadLineD)
                    return true;
            }
        }
        return false;
    }
}