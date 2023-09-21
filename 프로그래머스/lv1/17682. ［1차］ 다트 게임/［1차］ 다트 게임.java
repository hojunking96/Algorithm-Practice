import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String[] numStr = dartResult.split("[^0-9]+");
        int cnt = 0;
        int[] nums = new int[3];
        for(String e : numStr){
            nums[cnt++] = Integer.parseInt(e);
        }
        String[] func = dartResult.split("\\s*[0-9]+\\s*");
        for(int i = 1; i < 4; i++){
            if(func[i].contains("D")){
                nums[i - 1] = (int)Math.pow(nums[i - 1], 2);
            }
            if(func[i].contains("T")){
                nums[i - 1] = (int)Math.pow(nums[i - 1], 3);
            }
            if(func[i].contains("*")){
                nums[i - 1] *= 2;
                if(i != 1){
                    nums[i - 2] *= 2;
                }
            }
            if(func[i].contains("#")){
                nums[i - 1] *= -1;
            }
        }
        for(int e : nums){
            answer += e;
        }
        return answer;
    }
}

/*
숫자로 나누고
*이 있거나
S D T가 있는지 확인
*/