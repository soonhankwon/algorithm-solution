import java.util.stream.IntStream;

class Solution {
    
    private static final String WATER_MELLON = "수박";
    
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, n / 2).forEach(i -> sb.append(WATER_MELLON));
        if((n % 2) == 0) {
            return sb.toString();
        }
        return sb.append("수").toString();
    }
}