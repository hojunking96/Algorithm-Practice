import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        BigInteger up = factorial(balls);
        BigInteger down = factorial(balls - share).multiply(factorial(share));
        return (up.divide(down)).intValue();
    }
    private static BigInteger factorial(int k){
        BigInteger tmp = new BigInteger("1");
        for(int i = 1; i <= k; i++){
            tmp = tmp.multiply(new BigInteger("" + i));
        }
        return tmp;
    }
}