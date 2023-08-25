import java.util.stream.IntStream;

class Solution {
    
    static int count;
    
    public int solution(int[] absolutes, boolean[] signs) {
        count = 0;
        IntStream.range(0, absolutes.length).forEach(i -> {
            if (signs[i])
                count += absolutes[i];
            else
                count -= absolutes[i];
        });
        return count;
    }
}