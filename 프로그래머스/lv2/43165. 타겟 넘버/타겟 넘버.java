class Solution {
    private static int N;
    private static int cnt=0;
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        DFS(numbers,target,0,0);
        return cnt;
    }
    public static void DFS(int[]numbers,int target,int index,int result){
        if(index==N){
            if(result==target){
                cnt++;
            }
            return;
        }
        DFS(numbers,target,index+1,result+numbers[index]);
        DFS(numbers,target,index+1,result-numbers[index]);
    }
}