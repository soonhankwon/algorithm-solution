import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(clothes)
                .forEach(cloth -> map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1));

        int answer = map.values().stream()
                .mapToInt(value -> value + 1)
                .reduce(1, (a, b) -> a * b);

        return answer - 1;
    }
}