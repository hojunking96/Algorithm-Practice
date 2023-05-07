class Solution {
    public int solution(int[] numbers, int k) {
        int len = numbers.length;
        return numbers[(2 * (k - 1)) % len];
    }
}