import java.util.*;
import static java.util.stream.Collectors.joining;

class Solution {
    
    public String solution(int[] numbers) {        
        String[] sortedNumbers = Arrays.stream(numbers)
                    .boxed()
                    .map(String::valueOf)
                    .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                    .toArray(String[]::new); 
        if(sortedNumbers[0].equals("0")){
            return "0";
        }
        return Arrays.stream(sortedNumbers)
            .collect(joining());
    }
}
