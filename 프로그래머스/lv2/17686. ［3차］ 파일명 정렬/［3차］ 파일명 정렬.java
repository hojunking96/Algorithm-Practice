import java.util.*;

class Solution {
    private static class File {
        String head;
        String number;
        String tail;
        public File(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for(String e : files){
            int numStartPtr = -1;
            int numEndPtr = e.length() - 1;
            for(int i = 0; i < e.length(); i++){
                if(e.charAt(i) >= '0' && e.charAt(i) <= '9'){
                    numStartPtr = i;
                    break;
                }
            }
            for(int i = numStartPtr ; i < e.length(); i++){
                if(e.charAt(i) < '0' || e.charAt(i) > '9'){
                    numEndPtr = i - 1;
                    break;
                }
            }
            String head = e.substring(0, numStartPtr);
            String number = e.substring(numStartPtr, numEndPtr + 1);
            String tail = e.substring(numEndPtr + 1);
            list.add(new File(head, number, tail));
        }
        list.sort((o1, o2) -> {
            String str1 = o1.head.toLowerCase();
            String str2 = o2.head.toLowerCase();
            if (str1.compareTo(str2) == 0) {
                int n1 = Integer.parseInt(o1.number);
                int n2 = Integer.parseInt(o2.number);
                return n1 - n2;
            }
            return str1.compareTo(str2);
        });
        return list.stream()
            .map(x -> x.head + x.number + x.tail)
            .toArray(String[]::new);
    }
}