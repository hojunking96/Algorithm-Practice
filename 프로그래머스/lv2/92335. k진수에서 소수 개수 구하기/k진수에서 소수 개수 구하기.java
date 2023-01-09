import java.math.BigInteger;
import java.util.Stack;

class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
        answer = findPrime(convert(n, k));
        return answer;
    }

    public static int findPrime(String converted) {
        int i;
        int cnt = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (i = 0; i < converted.length(); i++) {
            if (converted.charAt(i) == '0') {
                if (converted.charAt(i - 1) == '0')
                    continue;
                endIndex = i;
                String tmp = converted.substring(startIndex, endIndex);
                if (primeCheck(tmp))
                    cnt++;
                startIndex = i + 1;
            }
        }
        endIndex = i;
        String tmp = converted.substring(startIndex, endIndex);
        if (primeCheck(tmp))
            cnt++;
        return cnt;
    }

    public static boolean primeCheck(String sub) {
        Long checkNum = Long.parseLong(sub);
        if (checkNum < 2)
            return false;
        int primeCnt = 0;
        for (long i = 2; i <= Math.sqrt(checkNum) + 1; i++) {
            if (i != checkNum && checkNum % i == 0) {
                primeCnt++;
            }
            if (primeCnt > 0)
                break;
        }
        if (primeCnt <= 0) {
            return true;
        }
        return false;
    }

    public static String convert(int n, int k) {
        Stack<Integer> stack = new Stack<>();
        String converted = "";
        int std = 0;
        while (n != 0) {
            stack.push(n % k);
            n = n / k;
        }
        while (!stack.isEmpty())
            converted += stack.pop();
        return converted;
    }
}
