import java.util.*;

class Solution {

    private int totalMemberCnt;
    private Map<String, Integer> map;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        totalMemberCnt = enroll.length;
        map = new HashMap<>();
        int[] result = new int[totalMemberCnt];

        map.put("-", -1);
        for (int i = 0; i < totalMemberCnt; i++) {
            map.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            //일단 자기한테 90% 돈을 넣어
            int index = map.get(seller[i]);
            int now = amount[i] * 100;
            int parentBonus = now / 10;
            result[index] += now - parentBonus;

            //부모를 찾아
            int parentIndex = map.get(referral[index]);

            //부모가 있다면
            while (parentIndex != -1 && parentBonus > 0) {

                // 10%의 90%를 가져
                now = parentBonus;
                parentBonus = now / 10;
                result[parentIndex] += now - parentBonus;

                //다시 부모가 누군지 세팅해야지
                index = parentIndex;
                parentIndex = map.get(referral[index]);
            }
        }
        return result;
    }
}