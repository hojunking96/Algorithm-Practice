class Solution {
    public int solution(String binomial) {
        String[] tmp = binomial.split(" ");
        int a = Integer.parseInt(tmp[0]);
        int b = Integer.parseInt(tmp[2]);
        if(tmp[1].equals("+")){
            return a + b;
        }
        else if(tmp[1].equals("-")){
            return a-b;
        }
        else{
            return a*b;
        }
    }
}