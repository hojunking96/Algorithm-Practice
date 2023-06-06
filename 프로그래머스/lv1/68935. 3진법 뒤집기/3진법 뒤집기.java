class Solution {
    public int solution(int n) {
        String three = Integer.toString(n, 3);
        StringBuffer sb = new StringBuffer(three);
        String reverse = sb.reverse().toString();
        return Integer.parseInt(reverse, 3);
    }
}