class Solution {
    public int solution(int hp) {
        int ant1 = hp / 5;
        hp %=5;
        int ant2 = hp / 3;
        hp %=3;
        int ant3 = hp;
        return ant1+ant2+ant3;
    }
}