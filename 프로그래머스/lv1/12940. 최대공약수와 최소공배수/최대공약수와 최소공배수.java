class Solution {
    public int[] solution(int n, int m) {
        int gcd = GCD(n, m);
        int lcm = n * m / gcd;
        return new int[]{gcd, lcm};
    }
    
    private int GCD(int a, int b){
        if(a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}