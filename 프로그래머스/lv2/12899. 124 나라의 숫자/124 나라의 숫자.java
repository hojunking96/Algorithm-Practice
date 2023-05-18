class Solution {
    public String solution(int n) {
        int i = 1;
        int cnt = 1;
        while(true){
            cnt = calcCnt(i);
            if(cnt >= n){
                break;
            }
            i++;
        }
        cnt /= 3;
        n -= cnt;
        String k = Integer.toString(n, 3);
        String answer = "0".repeat(i - k.length()) + k;
        answer = convert(answer);
        return answer;
    }
    
    private static int calcCnt(long k){
        return (int)(3 * (Math.pow(3, k) - 1) / 2);
    }
    
    private static String convert(String k){
        k = k.replaceAll("2","4");
        k = k.replaceAll("1","2");
        k = k.replaceAll("0","1");
        return k;
    }
    
}

/*

1~3  4~9  10 ~27
(0+1) ~ 3
(3+1) ~ 9
(9+1) ~ 27
(n/3+1) ~ n

24 ->214  23 -> 2, 7 -> 1  2 -> 2    212 -> 414

1자리 수는 1 빼고 3진법 때린다음 (0,1,2)를 (1,2,4) 로 바꾸면 됨
2자리 수는 4 빼고 3진법 때린다음 (0,1,2)를 (1,2,4) 로 바꾸면 됨
3자리 수는 13빼고 3진법 때린다음 바꿔 

k자리 수는 k-1 자리 수 * 3 개

01 02 03    01 02 04        3개
04 05 06    11 12 14        
07 08 09    21 22 24
10 11 12    41 42 44        3*3 + 3개
13 14 15    111 112 114     3*3*3 + 3*3 + 3개
16 17 18    121 122 124
19 20 21    141 142 144
22 23 24    211 212 214
25 26 27    221 222 224
28 29 30    241 242 244
31 32 33    411 412 414
34 35 36    421 422 424
37 38 39    441 442 444
...

*/