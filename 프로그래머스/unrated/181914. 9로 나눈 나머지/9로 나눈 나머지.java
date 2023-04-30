class Solution {
    public int solution(String number) {
        char[] k = number.toCharArray();
        int sum = 0;
        for(char e : k){
            sum += (int)(e - '0');
        }
        return sum % 9;
    }
}