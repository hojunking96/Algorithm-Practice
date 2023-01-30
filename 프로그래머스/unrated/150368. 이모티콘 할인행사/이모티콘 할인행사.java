import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    static class Kakao {
        public int userCount;
        public int salesSum;

        public Kakao(int userCount, int salesSum) {
            this.userCount = userCount;
            this.salesSum = salesSum;
        }
    }

    public static List<Kakao> kakaos;
    public static List<int[]> discountRates;
    public static int[] discountRate;
    
    public int[] solution(int[][] users, int[] emoticons) {
       int[] answer = new int[2];
        kakaos = new ArrayList<>();
        discountRates = new ArrayList<>();
        int emoticonSize = emoticons.length;
        discountRate = new int[emoticonSize];
        getDiscountRates(0, emoticonSize);
        calculate(users, emoticons);

        Collections.sort(kakaos, new Comparator<Kakao>() {
            @Override
            public int compare(Kakao o1, Kakao o2) {
                if (o1.userCount < o2.userCount) return 1;
                if (o1.userCount > o2.userCount) return -1;
                if (o1.salesSum < o2.salesSum) return 1;
                if (o1.salesSum > o2.salesSum) return -1;
                return 0;
            }
        });
        answer[0] = kakaos.get(0).userCount;
        answer[1] = kakaos.get(0).salesSum;
        return answer;
    }
    public static void calculate(int[][] users, int[] emoticons) {
        for (int j = 0; j < discountRates.size(); j++) {
            int cnt = 0;
            int totalUserSum = 0;
            for (int i = 0; i < users.length; i++) {
                int userSum = 0;
                int[] discounts = discountRates.get(j);
                for (int k = 0; k < emoticons.length; k++) {
                    if (users[i][0] <= discounts[k]) {
                        userSum += ((100 - discounts[k]) * emoticons[k] / 100);
                    }
                }
                if (userSum >= users[i][1]) {
                    cnt++;
                } else {
                    totalUserSum += userSum;
                }
            }
            kakaos.add(new Kakao(cnt, totalUserSum));
        }
    }

    public static void getDiscountRates(int start, int end) {
        if (start == end) {
            int[] tmp = new int[end];
            for (int i = 0; i < end; i++) {
                tmp[i] = discountRate[i];
            }
            discountRates.add(tmp);
            return;
        }
        for (int i = 1; i <= 4; i++) {
            discountRate[start] = i * 10;
            getDiscountRates(start + 1, end);
        }
    }
}