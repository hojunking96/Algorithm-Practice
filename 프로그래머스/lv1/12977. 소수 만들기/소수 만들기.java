import java.util.*;

class Solution {
    
    private List<Integer> arr = new ArrayList<>();
    private boolean[] isNotPrime = new boolean[3001];
    
    public int solution(int[] nums) {
        checkPrime();
        pickNumber(nums);
        int answer = 0;
        for(int e : arr){
            if(!isNotPrime[e]){
                answer++;
            }
        }
        return answer;
    }
    
    private void checkPrime(){
        for(int i = 2; i <= 3000; i++){
            if(!isNotPrime[i]){
                for(int j = i + i; j <= 3000; j += i){
                    isNotPrime[j] = true;
                }
            }
        }
    }
    
    private void pickNumber(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    arr.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
    }
}