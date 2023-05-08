import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        for(int i = 0; i < str1.length() - 1; i++){
            String tmp = str1.substring(i, i + 2);
            if(tmp.matches("^[a-z]*$")){
                arr1.add(tmp);
            }
        }
        for(int i = 0; i < str2.length() - 1; i++){
            String tmp = str2.substring(i, i + 2);
            if(tmp.matches("^[a-z]*$")){
                arr2.add(tmp);
            }
        }
        Collections.sort(arr1);
        Collections.sort(arr2);

        int len1 = arr1.size();
        int len2 = arr2.size();
        
        int ptr1 = 0;
        int ptr2 = 0;
        
        int commonCnt = 0;
        
        
        while(ptr1 != len1 && ptr2 != len2){
            String word1 = arr1.get(ptr1);
            String word2 = arr2.get(ptr2);
            
            if(word1.equals(word2)){
                ptr1++;
                ptr2++;
                commonCnt++;
            }
            else{
                if(word1.compareTo(word2) < 0){
                    ptr1++;
                }
                else{
                    ptr2++;
                }
            }
        }
        
        if(len1 + len2 - commonCnt == 0){
            return 65536;
        }
        return  65536 * commonCnt / (len1 + len2 - commonCnt);
    }
}