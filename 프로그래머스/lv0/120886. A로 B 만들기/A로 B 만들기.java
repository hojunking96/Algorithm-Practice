class Solution {
    public int solution(String before, String after) {
        int[] cnt = new int[26];
        for(int i=0;i<before.length();i++){
            cnt[before.charAt(i)-'a']++;
            cnt[after.charAt(i)-'a']--; 
        }
        int answer = 1;
        for(int i=0;i<26;i++){
            if(cnt[i]!=0){
                answer=0;
                break;
            }
        }
        return answer;
    }
}