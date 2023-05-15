import java.util.*;

class Solution {
    
    private static class Message{
        String ID;
        boolean isEnter;
        
        public Message(String ID, boolean isEnter){
            this.ID = ID;
            this.isEnter = isEnter;
        }
    }
    
    public String[] solution(String[] record) {
        List<Message> messages = new ArrayList<>();
        Map<String, String> IDs = new HashMap<>();
        for(String e : record){
            String[] rec = e.split(" ");
            String func = rec[0];
            String ID = rec[1];
            if(rec.length == 3){
                String nickname = rec[2];
                if(func.equals("Enter")){
                    IDs.put(ID, nickname);
                    messages.add(new Message(ID, true));
                }
                else if(func.equals("Change")){
                    IDs.put(ID, nickname);
                }
            }
            else{
                messages.add(new Message(ID, false));
            }
        }
        
        String[] answer = new String[messages.size()];
        int ptr = 0;
        for(Message message : messages){
            if(message.isEnter){
                answer[ptr] = IDs.get(message.ID) + "님이 들어왔습니다.";
            }
            else{
                answer[ptr] = IDs.get(message.ID) + "님이 나갔습니다.";
            }
            ptr++;
        }
        return answer;
    }
}
/*
Enter 이면 HashMap에서 확인
달라졌으면 HashMap에서 변경
똑같으면 그대로
Enter메시지 추가

Change 이면 HashMap에서 변경
Change 메시지는 없어

Leave 면 Leave 메세지만 추가

*/