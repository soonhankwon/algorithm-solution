import java.util.*;

public class Solution {
    public int solution(int n) {
        String number = String.valueOf(n);
        int length = number.length();
        int answer = 0;
        for(int i = 0; i < length; i++) {
            answer += Integer.valueOf((char) number.charAt(i) - 48);
        }
        return answer;
    }
}