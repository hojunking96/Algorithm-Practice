import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    public static class Truck {
        public int onTime;
        public int weight;

        public Truck(int weight) {
            this.onTime = 0;
            this.weight = weight;
        }
    }
    
    public static Queue<Truck> waitingTrucks = new LinkedList<>();
    public static Queue<Truck> movingTrucks = new LinkedList<>();
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        for (int k : truck_weights) {
            waitingTrucks.offer(new Truck(k));
        }
        while (!waitingTrucks.isEmpty()) {
            answer++;
            int totalWeight = 0;
            for (Truck k : movingTrucks) {
                k.onTime++;
            }
            if (!movingTrucks.isEmpty()) {
                Truck k = movingTrucks.peek();
                if (k.onTime == bridge_length)
                    movingTrucks.poll();
            }
            for (Truck k : movingTrucks) {
                totalWeight += k.weight;
            }
            if (movingTrucks.isEmpty()) {
                Truck newTruck = waitingTrucks.poll();
                movingTrucks.offer(newTruck);
            } else if (totalWeight + waitingTrucks.peek().weight <= weight) {
                Truck newTruck = waitingTrucks.poll();
                movingTrucks.offer(newTruck);
            }
        }
        return answer + bridge_length;
    }
}