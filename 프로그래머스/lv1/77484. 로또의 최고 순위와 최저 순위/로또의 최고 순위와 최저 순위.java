import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = (int) Arrays.stream(lottos)
                .filter(i -> i == 0).count();

        ArrayList<Integer> excludedZero = Arrays.stream(lottos)
                .filter(i -> i != 0)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        int count = (int) Arrays.stream(win_nums)
                .filter(excludedZero::contains)
                .count();

        if (zeroCount == 6) {
            return new int[]{1, 6};
        }
        else if (count + zeroCount == 0 || count + zeroCount == 1) {
            return new int[]{6, 6};
        }

        Function<Integer, Integer> function = integer -> 7 - integer;
        int[] result = new int[2];
        result[0] = function.apply(count + zeroCount);
        result[1] = function.apply(count);
        return result;
    }
}