import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        System.out.print(my_string.trim());
        return my_string.trim().split("\\s\\s*");
    }
}