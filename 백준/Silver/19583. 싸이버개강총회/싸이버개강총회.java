import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String e = st.nextToken();
        String q = st.nextToken();

        Set<String> before = new HashSet<>();
        Set<String> after = new HashSet<>();

        String str = null;
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            String time = st.nextToken();
            String name = st.nextToken();
            if (time.compareTo(s) <= 0) {
                before.add(name);
            } else if (time.compareTo(e) >= 0 && time.compareTo(q) <= 0) {
                after.add(name);
            }
        }

        int cnt = 0;
        for (String name : before) {
            if (after.contains(name)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}