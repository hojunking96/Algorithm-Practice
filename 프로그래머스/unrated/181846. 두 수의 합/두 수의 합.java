import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        String answer = "";
        BigInteger A = new BigInteger(a);
        BigInteger B = new BigInteger(b);
        BigInteger sum = A.add(B);
        return A.add(B).toString();
    }
}