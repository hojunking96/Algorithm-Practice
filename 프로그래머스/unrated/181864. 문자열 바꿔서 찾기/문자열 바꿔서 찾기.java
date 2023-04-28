class Solution {
    public int solution(String myString, String pat) {
        myString = myString.replaceAll("A", "b");
        myString = myString.replaceAll("B", "a");
        myString = myString.toUpperCase();
        System.out.println(myString);
        return myString.contains(pat) ? 1 : 0;
    }
}