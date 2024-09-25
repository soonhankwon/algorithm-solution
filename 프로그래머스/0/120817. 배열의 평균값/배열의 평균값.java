import java.util.*;

class Solution {
    public double solution(int[] numbers) {
        int sum = Arrays.stream(numbers)
            .map(Integer::valueOf)
            .sum();
        return (double) sum / numbers.length;
    }
}