import java.util.Arrays;
class Solution {
    public String solution(String s) {
        char[] cArr = s.toCharArray();
        Arrays.sort(cArr);
        StringBuilder sb = new StringBuilder();
        for(int i = cArr.length - 1; i >= 0; i--) {
            sb.append((char) cArr[i]);
        }
        return sb.toString();
    }
}