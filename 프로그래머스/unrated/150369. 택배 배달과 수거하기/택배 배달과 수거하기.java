import java.util.ArrayList;
import java.util.List;


class Solution {
    static class House {
        private int delivery;
        private int pickup;

        public House(int delivery, int pickup) {
            this.delivery = delivery;
            this.pickup = pickup;
        }

        public int getDelivery() {
            return delivery;
        }

        public int getPickup() {
            return pickup;
        }

        public void setDelivery(int delivery) {
            this.delivery = delivery;
        }

        public void setPickup(int pickup) {
            this.pickup = pickup;
        }

    }
    
    public static boolean deliveryEnd;
    public static boolean pickupEnd;
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
          long answer = 0;
        List<House> houses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            House house = new House(deliveries[i], pickups[i]);
            houses.add(house);
        }
        if (!needDelivery(houses) && !needPickup(houses)) {
            return 0;
        }
        while (houses.size() != 0) {
            int houseIndex = houses.size();
            if (!deliveryEnd)
                go(cap, houses);
            if (!pickupEnd) {
                back(cap, houses);
            }
            answer += houseIndex;
            for (int i = houseIndex - 1; i >= 0; i--) {
                if (houses.get(i).getDelivery() == 0 && houses.get(i).getPickup() == 0) {
                    houses.remove(i);
                } else {
                    break;
                }
            }
        }
        answer *= 2;
        return answer;
    }

    public static void go(int cap, List<House> houses) {
        int box = cap;
        int endPoint = houses.size() - 1;
        int i;
        for (i = endPoint; i >= 0; i--) {
            int lastDelivery = houses.get(i).getDelivery();
            if (box > lastDelivery) {
                box -= lastDelivery;
                houses.get(i).setDelivery(0);
            } else {
                houses.get(i).setDelivery(lastDelivery - box);
                break;
            }
        }
        if (i == -1 && houses.get(0).getDelivery() == 0)
            deliveryEnd = true;
    }

    public static void back(int cap, List<House> houses) {
        int box = cap;
        int endPoint = houses.size() - 1;
        int i;
        for (i = endPoint; i >= 0; i--) {
            int lastPickup = houses.get(i).getPickup();
            if (box > lastPickup) {
                box -= lastPickup;
                houses.get(i).setPickup(0);

            } else {
                houses.get(i).setPickup(lastPickup - box);
                break;
            }
        }
        if (i == -1 && houses.get(0).getPickup() == 0)
            pickupEnd = true;
    }

    public static boolean needDelivery(List<House> houses) {
        for (int i = 0; i < houses.size(); i++) {
            if (houses.get(i).getDelivery() != 0)
                return true;
        }
        return false;
    }

    public static boolean needPickup(List<House> houses) {
        for (int i = 0; i < houses.size(); i++) {
            if (houses.get(i).getPickup() != 0)
                return true;
        }
        return false;
    }
}
