class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        int carryBit = 0;
        int num1 = Integer.parseInt(bin1);
        int num2 = Integer.parseInt(bin2);
        if(num1 == 0 && num2 == 0){
            return "0";
        }
        while(num1 != 0 && num2 != 0){
            int n1 = num1 % 10;
            int n2 = num2 % 10;
            num1 /= 10;
            num2 /= 10;
            int sum = n1 + n2 + carryBit;
            answer = sum % 2 + answer;
            if(sum >= 2){
                carryBit = 1;
            }
            else{
                carryBit = 0;
            }
        }
        while(num1 != 0){
            int n1 = num1 % 10;
            num1 /= 10;
            int sum = n1 + carryBit;
            answer = sum % 2 + answer;
            if(sum >= 2){
                carryBit = 1;
            }
            else{
                carryBit = 0;
            }
        }
        while(num2 != 0){
            int n2 = num2 % 10;
            num2 /= 10;
            int sum = n2 + carryBit;
            answer = sum % 2 + answer;
            if(sum >= 2){
                carryBit = 1;
            }
            else{
                carryBit = 0;
            }
        }
        if(carryBit == 1){
            answer = 1 + answer;
        }
        return answer;
    }
}