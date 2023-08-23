import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Solution {
    public static String[] solution(String[] players, String[] callings) {
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        IntStream.rangeClosed(1, players.length).forEach(i -> map1.put(i, players[i - 1]));
        IntStream.rangeClosed(1, players.length).forEach(i -> map2.put(players[i - 1], i));

        for (String calling : callings) {
            Integer rank = map2.get(calling);
            String frontOfCalledPlayer = map1.get(rank - 1);
            map1.put(rank, frontOfCalledPlayer);
            map1.put(rank - 1, calling);
            map2.put(frontOfCalledPlayer, rank);
            map2.put(calling, rank - 1);
        }

        String[] answer = new String[players.length];
        return map1.values().toArray(answer);
    }
}