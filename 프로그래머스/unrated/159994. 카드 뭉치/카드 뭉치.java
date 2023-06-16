class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int ptr1 = 0;
        int ptr2 = 0;
        for(String g : goal){
            if(ptr1 < cards1.length && cards1[ptr1].equals(g)){
                ptr1++;
            }
            else if(ptr2 < cards2.length && cards2[ptr2].equals(g)){
                ptr2++;
            }
            else{
                return "No";
            }
        }
        return "Yes";
    }
}