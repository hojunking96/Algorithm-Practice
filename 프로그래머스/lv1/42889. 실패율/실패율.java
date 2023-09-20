import java.util.*;

class Solution {

    class Step {
        int stageNum;
        double failRate;

        Step(int stageNum, double failRate) {
            this.stageNum = stageNum;
            this.failRate = failRate;
        }

        public int getStageNum() {
            return this.stageNum;
        }
    }

    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : stages) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        List<Step> arr = new ArrayList<>();
        int totalCnt = stages.length;
        for (int i = 0; i < N; i++) {
            if (map.containsKey(i + 1)) {
                arr.add(new Step(i + 1, (double) map.get(i + 1) / totalCnt));
                totalCnt -= map.get(i + 1);
            } else {
                arr.add(new Step(i + 1, 0));
            }
        }
        return arr.stream()
                .sorted((o1, o2) -> {
                    if (o1.failRate == o2.failRate) {
                        return o1.stageNum - o2.stageNum;
                    }
                    if (o1.failRate > o2.failRate) {
                        return -1;
                    }
                    return 1;
                })
                .mapToInt(Step::getStageNum)
                .toArray();
    }
}