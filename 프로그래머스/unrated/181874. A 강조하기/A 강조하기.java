class Solution {
    public String solution(String myString) {
        return myString.replaceAll("a","3").replaceAll("A","3").toLowerCase().replaceAll("3","A");
    }
}