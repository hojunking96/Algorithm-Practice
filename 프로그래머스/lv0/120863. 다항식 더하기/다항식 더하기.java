class Solution {
    public String solution(String polynomial) {
        String[] arr = polynomial.split(" ");
        
        int xCnt = 0;
        int numCnt = 0;
        for(String a : arr){
            if(a.equals("+")){
               continue; 
            }
            if(a.contains("x")){
                if(a.length() == 1){
                    xCnt++;
                    continue;
                }
                xCnt += Integer.parseInt(a.substring(0, a.length() - 1));
            }
            else{
                numCnt += Integer.parseInt(a);
            }
        }
        String numString = "";
        String xString = "";
        if(numCnt != 0){
            numString += numCnt;
        }
        if(xCnt != 0){
            if(xCnt == 1){
                xString = "x";
            }
            else{
                xString = "" + xCnt + "x";
            }
        }
        if(numCnt != 0 && xCnt != 0){
            numString = " + " + numString;
        }
        return xString + numString;
    }
}