import java.util.*;

class Solution {
    
    public long solution(String expression) {        
        List<String> arr = new ArrayList<>();
        arr = divideExpression(expression, arr);
        return findMax(arr);
    }
    
    private static List<String> divideExpression(String expression, List<String> arr){
        String tmp = "";
        for(int i = 0; i < expression.length(); i++){
            char v = expression.charAt(i);
            if(isOperator(v)){
                arr.add(tmp);
                arr.add("" + v);
                tmp = "";
            }
            else{
                tmp += v;
            }
        }
        arr.add(tmp);
        return arr;
    }
    
    private static boolean isOperator(char k){
        return k == '+' || k == '-' || k == '*';
    }
    
    private static long findMax(List<String> arr){
        long max = 0;
        if(arr.size() == 1){
            return Long.parseLong(arr.get(0));
        }
        long[] result = new long[6];
        result[0] = Long.parseLong(doPlus(doMinus(doMultiply(arr))).get(0));
        result[1] = Long.parseLong(doPlus(doMultiply(doMinus(arr))).get(0));
        result[2] = Long.parseLong(doMinus(doPlus(doMultiply(arr))).get(0));
        result[3] = Long.parseLong(doMinus(doMultiply(doPlus(arr))).get(0));
        result[4] = Long.parseLong(doMultiply(doMinus(doPlus(arr))).get(0));
        result[5] = Long.parseLong(doMultiply(doPlus(doMinus(arr))).get(0));
        for(long e : result){
            max = Math.max(max, Math.abs(e));
        }
        return max;
    }
    
    private static List<String> doPlus(List<String> arr){
        List<String> newArr = new ArrayList<>();
        int ptr = 0;
        for (int i = 0; i < arr.size(); i++, ptr++) {
            if (arr.get(i).equals("+")) {
                Long prev = Long.parseLong(newArr.get(ptr - 1));
                Long next = Long.parseLong(arr.get(i + 1));
                ptr--;
                newArr.set(ptr, "" + (prev + next));
                i++;
            } else {
                newArr.add(arr.get(i));
            }
        }
        return newArr;
    }
    
    private static List<String> doMinus(List<String> arr){
        List<String> newArr = new ArrayList<>();
        int ptr = 0;
        for (int i = 0; i < arr.size(); i++, ptr++) {
            if (arr.get(i).equals("-")) {
                Long prev = Long.parseLong(newArr.get(ptr - 1));
                Long next = Long.parseLong(arr.get(i + 1));
                ptr--;
                newArr.set(ptr, "" + (prev - next));
                i++;
            } else {
                newArr.add(arr.get(i));
            }
        }
        return newArr;
    }
    
    private static List<String> doMultiply(List<String> arr){
        List<String> newArr = new ArrayList<>();
        int ptr = 0;
        for (int i = 0; i < arr.size(); i++, ptr++) {
            if (arr.get(i).equals("*")) {
                Long prev = Long.parseLong(newArr.get(ptr - 1));
                Long next = Long.parseLong(arr.get(i + 1));
                ptr--;
                newArr.set(ptr, "" + (prev * next));
                i++;
            } else {
                newArr.add(arr.get(i));
            }
        }
        return newArr;
    }
}

/*
+  *  -  가 포함된 수식이 주어짐
우선순위를 자유롭게 재정의해서 가장 큰 숫자를 만들어라
우선순위는 동일한 것이 없다. 무조건 한쪽이 먼저

절대값이 가장 큰 경우에 1등, 그만큼 당첨상금을 준다.

곱하기를 기준으로 가장 절댓값이 크게만들어야함
A+B*C 면 A+B가 가장 절대값이 커야 의미가 있음

* 기준으로 나눈다음에
좌항 우항을 + , - 에 대한 우선순위만 고려해서 해봐


*/