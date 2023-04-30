class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        if(len2 > len1){
            return -1;
        }
        if(len1 > len2){
            return 1;
        }
        int sum1 = 0;
        for(int e: arr1){
            sum1 += e;
        }
        int sum2 = 0;
        for(int e: arr2){
            sum2 += e;
        }
        if(sum1 > sum2){
            return 1;   
        }
        if(sum1 < sum2){
            return -1;
        }
        return 0;
    }
}