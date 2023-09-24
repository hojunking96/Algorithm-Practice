import java.util.*;

class Solution {
    
    private Map<Character, Integer> scores = new HashMap<>(); 
    
    public String solution(String[] survey, int[] choices) {
        scores.put('R', 0);
        scores.put('T', 0);
        scores.put('C', 0);
        scores.put('F', 0);
        scores.put('J', 0);
        scores.put('M', 0);
        scores.put('A', 0);
        scores.put('N', 0);
        for(int i = 0; i < survey.length; i++){
            count(survey[i], choices[i]);
        }
        String answer = getResult();
        return answer;
    }
    
    public String getResult(){
        String tmp = "";
        if(scores.get('T') > scores.get('R')){
            tmp += 'T';
        }
        else{
            tmp += 'R';
        }
        if(scores.get('F') > scores.get('C')){
            tmp += 'F';
        }
        else{
            tmp += 'C';
        }
        if(scores.get('M') > scores.get('J')){
            tmp += 'M';
        }
        else{
            tmp += 'J';
        }
        if(scores.get('N') > scores.get('A')){
            tmp += 'N';
        }
        else{
            tmp += 'A';
        }
        return tmp;
    }
    
    public void count(String std, int choice){
        int index = 0;
        int score = 0;
        switch(choice){
            case 1:
                index = 0;
                score = 3;
                break;
            case 2:
                index = 0;
                score = 2;
                break;
            case 3:
                index = 0;
                score = 1;
                break;
            case 4:
                break;
            case 5:
                index = 1;
                score = 1;
                break;
            case 6:
                index = 1;
                score = 2;
                break;
            default:
                index = 1;
                score = 3;
                break;
        }
        char x = std.charAt(index);
        scores.put(x, scores.get(x) + score);
    }
}

/*
R / T
C / F
J / M
A / N
*/