import java.util.*;

class Solution {
    public int solution(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        if(arr[0] == arr[2]){
            return (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
        }
        else if(arr[0] == arr[1] || arr[1] == arr[2]){
            return (a + b + c) * (a * a + b * b + c * c);
        }
        else{
            return a + b + c;
        }
    }
}