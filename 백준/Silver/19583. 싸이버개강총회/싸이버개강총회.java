import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] times = new int[3];
        String[] input = br.readLine().split(" ");
        Set<String>[] members = new Set[2];
        for (int i = 0; i < 2; i++) {
            members[i] = new HashSet<>();
        }
        
        for (int i = 0; i < 3; i++) {
            times[i] = Integer.parseInt(input[i].replace(':', '0'));
        }


        String str = null;
        while ((str = br.readLine()) != null) {
            String[] str2 = str.split(" ");
            int time = Integer.parseInt(str2[0].replace(':', '0'));
            String name = str2[1];
            if (time <= times[0]) {
                members[0].add(name);
            } else if (time >= times[1] && time <= times[2]) {
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