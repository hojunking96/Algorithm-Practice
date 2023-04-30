class Solution {
    public int solution(String s) {
        String[] arr = s.split(" ");
        int prev = 0;
        int sum = 0;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i].equals("Z")){
                System.out.print(sum + " ");
                sum -= prev;
            }
            else{
                sum += Integer.parseInt(arr[i]);
                prev = Integer.parseInt(arr[i]);
            }
        }
        return sum;
    }
}