import java.util.function.Function;

class Solution {
    public int solution(int angle) {
        Function<Integer, Integer> function = i -> {
            if (i > 0 && i < 90)
                return 1;
            if (i == 90)
                return 2;
            if (i > 90 && i < 180)
                return 3;
            if (i == 180)
                return 4;
            throw new IllegalStateException();
        };
        return function.apply(angle);
    }
}