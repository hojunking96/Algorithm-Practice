class Solution {
    public int solution(int n, int k) {
        String[] converted = Integer.toString(n, k).split("0");
        return findPrime(converted);
    }
    
    public static int findPrime(String[] converted) {
        int cnt = 0;
        for (int i = 0; i < converted.length; i++)
            if (primeCheck(converted[i]))
                cnt++;
        return cnt;
    }

    public static boolean primeCheck(String sub) {
        if (sub.equals(""))
            return false;
        Long checkNum = Long.parseLong(sub);
        if (checkNum < 2)
            return false;
        for (long i = 2; i <= Math.sqrt(checkNum); i++)
            if (i != checkNum && checkNum % i == 0)
                return false;
        return true;
    }
}