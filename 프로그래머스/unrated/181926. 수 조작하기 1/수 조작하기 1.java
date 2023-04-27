class Solution {
    public int solution(int n, String control) {
        for(int i = 0; i < control.length(); i++){
            char k = control.charAt(i);
            switch(k){
                case 'w':
                    n++;
                    break;
                case 's':
                    n--;
                    break;
                case 'd':
                    n += 10;
                    break;
                default:
                    n -= 10;
                    break;
            }
        }
        return n;
    }
}