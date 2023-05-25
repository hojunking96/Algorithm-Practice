class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        for(int i = 0; i <= t.length() - len; i++){
            String newString = t.substring(i, i + len);
            Long tmp = Long.parseLong(newString);
            System.out.println(tmp);
            if(tmp <= Long.parseLong(p)){
                answer++;
            }
        }
        return answer;
    }
}