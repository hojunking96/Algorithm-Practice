import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
    
        String tmp = "";
        char[] arr = a.toCharArray();
        for(char e : arr){
            if(e >= 'a' && e <= 'z'){
                tmp += (char)(e + ('A' - 'a'));
            }
            else{
                tmp += (char)(e - ('A' - 'a'));
            }
        }
        System.out.print(tmp);
    }
}