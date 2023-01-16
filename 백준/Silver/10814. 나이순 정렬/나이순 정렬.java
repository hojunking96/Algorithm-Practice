import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static class User {
        private int age;
        private String name;
        private int id;

        public int getId() {
            return id;
        }

        public User(int age, String name, int id) {
            this.age = age;
            this.name = name;
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

    }

    public static StringBuilder sb;
    public static List<User> users;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        users = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tmpAge = Integer.parseInt(st.nextToken());
            String tmpName = st.nextToken();
            users.add(new User(tmpAge, tmpName, i));
        }
        users.sort(Comparator.comparing(User::getAge).thenComparing(User::getId));

        for (User e : users) {
            sb.append(e.getAge()).append(" ").append(e.getName()).append("\n");
        }
        System.out.println(sb);
    }
}