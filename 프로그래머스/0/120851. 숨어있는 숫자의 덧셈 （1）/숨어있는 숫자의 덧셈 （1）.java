import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        for(int i = 1; i < 10; i++) {
            set.add(String.valueOf(i));
        }
        int length = my_string.length();
        for(int i = 0; i < length; i++) {
            String value = String.valueOf(my_string.charAt(i));
            if(set.contains(value)) {
                answer += Integer.valueOf(value);
            }
        }
        return answer;
    }
}