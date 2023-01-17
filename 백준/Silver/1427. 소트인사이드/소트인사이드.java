import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Main {

    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);
        sb = new StringBuilder(String.valueOf(arr)).reverse();
        System.out.println(sb);
    }
}