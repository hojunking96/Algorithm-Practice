class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int index = 0; index < numbers.length; index++){
            String binary = "0" + Long.toString(numbers[index], 2);
            int ptr1 = binary.length();
            int ptr2 = -1;
            for(int i = binary.length() - 1; i >= 0; i--){
                if(binary.charAt(i) == '0'){
                    ptr1 = i;
                    break;
                }
            }
            for(int i = ptr1 + 1; i < binary.length(); i++){
                if(binary.charAt(i) == '1'){
                    ptr2 = i;
                    break;
                }
            }
            binary = binary.substring(0, ptr1) + "1" + binary.substring(ptr1 + 1);
            if(ptr2 != -1){
                binary = binary.substring(0, ptr2) + "0" + binary.substring(ptr2 + 1);
            }
            answer[index] = Long.parseLong(binary, 2);
        }
        return answer;
    }
}