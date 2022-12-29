import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        int addCount;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        addCount = classify(numbers, br.readLine());
        System.out.println(calculate(numbers, addCount));
        br.close();
    }

    private static int classify(List<Integer> numbers, String input) {
        int startIndex = 0;
        int addCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-') {
                numbers.add(Integer.parseInt(input.substring(startIndex, i)));
                startIndex = i + 1;
                if (addCount == 0 && input.charAt(i) == '-')
                    addCount = numbers.size();
            }
        }
        numbers.add(Integer.parseInt(input.substring(startIndex, input.length())));
        return addCount;
    }

    private static int calculate(List<Integer> numbers, int addCount) {
        int sum = 0;
        if (addCount == 0) {
            for (int e : numbers)
                sum += e;
            return sum;
        }
        for (int i = 0; i < addCount; i++) {
            sum += numbers.get(i);
        }
        for (int i = addCount; i < numbers.size(); i++) {
            sum -= numbers.get(i);
        }
        return sum;
    }
}
