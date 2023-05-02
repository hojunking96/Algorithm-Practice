class Solution {
    public int solution(String[] spell, String[] dic) {
        for(String e : dic){
            boolean flag = true;
            for(String str : spell){
                if(!e.contains(str)){
                    flag = false;
                    break;
                }
                e = e.replace(str, "");
            }
            if(flag && e.equals("")){
                return 1;
            }
        }
        return 2;
    }
}