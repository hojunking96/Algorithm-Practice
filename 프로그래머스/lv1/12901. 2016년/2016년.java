class Solution {
    public String solution(int a, int b) {
        int[] months = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int dayDiff = 0;
        for(int i = 1; i <= a - 1; i++){
            dayDiff += months[i];
        }
        dayDiff += b - 1;
        dayDiff = (dayDiff + 5) % 7;
        return days[dayDiff];
    }
}