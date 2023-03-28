import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Value {
        int x;
        int y;
        boolean isLeft;

        public Value(int x, int y, boolean isLeft) {
            this.x = x;
            this.y = y;
            this.isLeft = isLeft;
        }
    }

    private static HashMap<Character, Value> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char L = st.nextToken().charAt(0);
        char R = st.nextToken().charAt(0);
        String sentence = br.readLine();
        init();
        int leftX = map.get(L).x;
        int leftY = map.get(L).y;
        int rightX = map.get(R).x;
        int rightY = map.get(R).y;
        int timeCnt = 0;

        for (int i = 0; i < sentence.length(); i++) {
            char key = sentence.charAt(i);
            Value value = map.get(key);
            if (value.isLeft) {
                timeCnt += Math.abs(value.x - leftX);
                timeCnt += Math.abs(value.y - leftY);
                leftX = value.x;
                leftY = value.y;
            } else {
                timeCnt += Math.abs(value.x - rightX);
                timeCnt += Math.abs(value.y - rightY);
                rightX = value.x;
                rightY = value.y;
            }
            timeCnt++;
        }
        System.out.println(timeCnt);
    }

    private static void init() {
        map = new HashMap<>();
        map.put('q', new Value(0, 0, true));
        map.put('w', new Value(0, 1, true));
        map.put('e', new Value(0, 2, true));
        map.put('r', new Value(0, 3, true));
        map.put('t', new Value(0, 4, true));
        map.put('y', new Value(0, 5, false));
        map.put('u', new Value(0, 6, false));
        map.put('i', new Value(0, 7, false));
        map.put('o', new Value(0, 8, false));
        map.put('p', new Value(0, 9, false));

        map.put('a', new Value(1, 0, true));
        map.put('s', new Value(1, 1, true));
        map.put('d', new Value(1, 2, true));
        map.put('f', new Value(1, 3, true));
        map.put('g', new Value(1, 4, true));
        map.put('h', new Value(1, 5, false));
        map.put('j', new Value(1, 6, false));
        map.put('k', new Value(1, 7, false));
        map.put('l', new Value(1, 8, false));

        map.put('z', new Value(2, 0, true));
        map.put('x', new Value(2, 1, true));
        map.put('c', new Value(2, 2, true));
        map.put('v', new Value(2, 3, true));
        map.put('b', new Value(2, 4, false));
        map.put('n', new Value(2, 5, false));
        map.put('m', new Value(2, 6, false));
    }
}