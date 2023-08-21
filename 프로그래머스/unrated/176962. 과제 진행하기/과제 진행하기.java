import java.util.*;

class Solution {
    
    class Assignment{
        String name;
        int startMinute;
        int requiredMinute;
        
        Assignment(String name, int startMinute, int requiredMinute){
            this.name = name;
            this.startMinute = startMinute;
            this.requiredMinute = requiredMinute;
        }
    }
    
    public String[] solution(String[][] plans) {
        List<Assignment> assignments = new ArrayList<>();
        for(String[] plan : plans){
            assignments.add(new Assignment(plan[0], convertTimeToMinute(plan[1]), Integer.parseInt(plan[2])));
        }
        Collections.sort(assignments, Comparator.comparing(o -> o.startMinute));
        
        int length = plans.length;
        String[] answer = new String[length];
        int idx = 0;
        
        Stack<Assignment> stack = new Stack<>();
        
        for(int i = 0; i < length; i++){
            //지금
            Assignment now = assignments.get(i);
            //다음꺼
            if(i + 1 >= length){
                stack.push(now);
                break;
            }
            Assignment next = assignments.get(i + 1);
            //시간 차이 계산
            int timeLeft = next.startMinute - now.startMinute;
            //지금꺼 못 끝내면 남은시간 갱신하고 스택에 넣어
            if(timeLeft < now.requiredMinute){
                now.requiredMinute -= timeLeft;
                stack.push(now);
            }
            //지금꺼 딱 끝내면 지금꺼를 정답에 추가
            else if(timeLeft == now.requiredMinute){
                answer[idx++] = now.name;
            }
            //지금꺼 끝내고 시간 남으면
            else{
                //정답에 추가하고 남은시간 갱신
                answer[idx++] = now.name;
                timeLeft -= now.requiredMinute;
                //미룬 과제가 있고, 시간이 남았을 때
                while(!stack.isEmpty() && timeLeft > 0){
                    Assignment before = stack.pop();
                    
                    //지금꺼 못 끝내면 남은시간 갱신하고 스택에 넣어
                    if(timeLeft < before.requiredMinute){
                        before.requiredMinute -= timeLeft;
                        stack.push(before);
                        break;
                    }
                    //지금꺼 딱 끝내면 지금꺼를 정답에 추가
                    else if(timeLeft == before.requiredMinute){
                        answer[idx++] = before.name;
                        break;
                    }
                    //끝내고도 시간이 남으면 계산하고 넘겨
                    else{
                        timeLeft -= before.requiredMinute;
                        answer[idx++] = before.name;
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            answer[idx++] = stack.pop().name;
        }
        return answer;
    }
    
    private int convertTimeToMinute(String time){
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
}