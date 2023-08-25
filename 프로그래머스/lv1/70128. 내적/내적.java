import java.util.stream.IntStream;

class Solution {
    
    static int count;
    
    public int solution(int[] a, int[] b) {
        count = 0;
        IntStream.range(0, a.length).forEach(i -> count += (a[i] * b[i]));
        return count;
    }
}