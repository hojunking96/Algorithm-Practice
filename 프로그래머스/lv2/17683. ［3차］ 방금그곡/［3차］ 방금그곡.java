import java.util.*;

class Solution {
    
    private static Map<String, String> map = new HashMap<>();
    
    public String solution(String m, String[] musicinfos) {
        m = init(m);
        String answer = "(None)";
        int maxRunningTime = 0;
        
        for(String musicinfo : musicinfos){
            String[] music = musicinfo.split(",");
            
            int runningTime = calcRunningTime(music[0], music[1]);
            String pitches = convertPitch(music[3]);
            String melody = makeMelody(pitches, runningTime);
            
            if(melody.contains(m)){
                if(maxRunningTime < runningTime){
                    answer = music[2];
                    maxRunningTime = runningTime;
                }
            }
        }
        return answer;
    }
    
    private static String init(String m){
        initMap();
        return convertPitch(m);
    }
    
    private static String convertPitch(String pitches){
        for(String pitch : map.keySet()){
            pitches = pitches.replaceAll(pitch, map.get(pitch));
        }
        return pitches;
    }
    
    private static String makeMelody(String pitches, int runningTime){        
        int len = pitches.length();

        String melody = "";
        for(int i = 0; i < runningTime; i++){
            melody += pitches.charAt(i % len);
        }
        return melody;
    }
    
    private static void initMap(){
        map.put("C#", "c");
        map.put("D#", "d");
        map.put("F#", "f");
        map.put("G#", "g");
        map.put("A#", "a");
    }
    
    private static int calcRunningTime(String startTime, String endTime){
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        int runningTime = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
        runningTime *= 60;
        runningTime += Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
        return runningTime;
    }
}
/*
음이 총 12가지 알파벳+# 꼴로 되어있음
시작, 끝 , 제목, 악보


*/