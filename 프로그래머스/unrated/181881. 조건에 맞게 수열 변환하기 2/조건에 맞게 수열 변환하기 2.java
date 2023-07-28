class Solution {
    public int solution(int[] arr) {
        int answer = -1;
        while(true){
            int[] newArr = doJob(arr);
            if(isEqual(newArr, arr)){
                return answer;
            }
            arr = newArr;
            answer++;
        }
    }
    private boolean isEqual(int[] newArr, int[] arr){
        for(int i = 0; i < newArr.length; i++){
            if(newArr[i] != arr[i]){
                return false;
            }
        }
        return true;
    }
    private int[] doJob (int[] arr){
        int[] newArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 50 && arr[i] % 2 == 0){
                newArr[i] /= 2;
            }
            else if(arr[i] < 50 && arr[i] % 2 == 1){
                newArr[i] = arr[i] * 2 + 1;
            }
        }
        return newArr;
    }
}