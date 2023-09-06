import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Comparator<String> comparingIndex = Comparator.comparingInt(o -> o.charAt(n));
        return Arrays.stream(strings)
                .sorted(comparingIndex.thenComparing(Comparator.naturalOrder()))
                .toArray(String[]::new);
    }
}