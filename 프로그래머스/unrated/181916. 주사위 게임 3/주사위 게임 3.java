import java.util.*;

class Solution {
    
    class Result{
        int number;
        int cnt;
        
        Result(int number, int cnt){
            this.number = number;
            this.cnt = cnt;
        }
    }
    
    private List<Result> results = new ArrayList<>();
    
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] cnts = new int[7];
        cnts[a]++;
        cnts[b]++;
        cnts[c]++;
        cnts[d]++;
        for(int i = 1; i <= 6; i++){
            results.add(new Result(i, cnts[i]));            
        }
        Collections.sort(results, (o1, o2) -> o2.cnt - o1.cnt);

        int firstCnt = results.get(0).cnt;
        int firstNum = results.get(0).number;
        int secondCnt = results.get(1).cnt;
        int secondNum = results.get(1).number;
        if(firstCnt == 4){
            return 1111 * firstNum;
        }
        if(firstCnt == 3){
            int tmp = 10 * firstNum + secondNum;
            return tmp * tmp;
        }
        if(firstCnt == 2){
            if(secondCnt == 2){
                return (firstNum + secondNum) * Math.abs(firstNum - secondNum);
            }
            return secondNum * results.get(2).number;
        }
        return Math.min(Math.min(firstNum, secondNum), Math.min(results.get(2).number, results.get(3).number));
    }
}