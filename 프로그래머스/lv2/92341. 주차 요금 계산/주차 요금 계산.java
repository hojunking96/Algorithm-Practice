import java.util.*;
class Solution {
  
 public static class Info {
        int cost = 0;
        int inTime;
        int outTime = 0;
        int totalTime = 0;
        boolean isIn = false;

    }

    public static Map<String, Info> infos;
    public static List<String> carNums;

     public int[] solution(int[] fees, String[] records) {
        infos = new HashMap<>();
        carNums = new ArrayList<>();
        saveInfo(records);
        for (String carNum : carNums) {
            if (infos.get(carNum).isIn) {
                infos.get(carNum).totalTime += infos.get(carNum).outTime - infos.get(carNum).inTime;
            }
            calculateCost(fees, infos.get(carNum));
        }
        int[] answer = new int[carNums.size()];
        List<String> keyList = new ArrayList<>(infos.keySet());
        keyList.sort(String::compareTo);
        for (int i = 0; i < keyList.size(); i++) {
            answer[i] = infos.get(keyList.get(i)).cost;
        }
        return answer;
    }

    public static void saveInfo(String[] records) {
        for (int i = 0; i < records.length; i++) {
            String[] inputs = records[i].split(" ");
            String time = inputs[0];
            String carNum = inputs[1];
            String type = inputs[2];
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));
            if (type.equals("IN")) {
                if (!infos.containsKey(carNum)) {
                    carNums.add(carNum);
                    infos.put(carNum, new Info());
                }
                infos.get(carNum).inTime = hour * 60 + minute;
                infos.get(carNum).outTime = 23 * 60 + 59;
                infos.get(carNum).isIn = true;
            } else {
                infos.get(carNum).outTime = hour * 60 + minute;
                infos.get(carNum).isIn = false;
                infos.get(carNum).totalTime += infos.get(carNum).outTime - infos.get(carNum).inTime;
            }
        }
    }

    public static void calculateCost(int[] fees, Info info) {
        if (info.totalTime == 0) {
            return;
        }
        if (info.totalTime <= fees[0]) {
            info.cost = fees[1];
            return;
        }
        info.cost += fees[1];
        info.totalTime -= fees[0];
        if (info.totalTime % fees[2] == 0) {
            info.cost += info.totalTime / fees[2] * fees[3];
            return;
        }
        info.cost += (info.totalTime / fees[2] + 1) * fees[3];
    }
}