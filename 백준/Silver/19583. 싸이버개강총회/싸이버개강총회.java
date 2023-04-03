import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] times = br.readLine().split(" ");
        Set<String>[] members = new Set[2];
        for (int i = 0; i < 2; i++) {
            members[i] = new HashSet<>();
        }

        String str = null;
        while ((str = br.readLine()) != null) {
            String[] str2 = str.split(" ");
            String name = str2[1];
            if (str2[0].compareTo(times[0]) <= 0) {
                members[0].add(name);
            } else if (str2[0].compareTo(times[1]) >= 0 && str2[0].compareTo(times[2]) <= 0) {
                members[1].add(name);
            }
        }

        int cnt = 0;
        for (String name : members[0]) {
            if (members[1].contains(name)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}