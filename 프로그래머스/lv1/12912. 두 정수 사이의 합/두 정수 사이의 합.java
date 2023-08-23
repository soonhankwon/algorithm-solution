import java.util.stream.LongStream;

class Solution {
    public long solution(int a, int b) {
        if (a > b)
            return sum(b, a);
        else
            return sum(a, b);
    }

    private static long sum(int a, int b) {
        return LongStream.rangeClosed(a, b).sum();
    }
}