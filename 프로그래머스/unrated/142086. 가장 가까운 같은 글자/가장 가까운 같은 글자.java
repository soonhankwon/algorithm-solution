import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> currentMap = new HashMap<>();

        int sLength = s.length();
        int[] answer = new int[sLength];
        for (int i = 0; i < sLength; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (!map.containsKey(c)) {
                currentMap.put(c, i);
            }
            if (map.get(c) != null && map.get(c) > 1) {
                answer[i] = i - currentMap.get(c);
                currentMap.put(c, i);
            } else {
                answer[i] = -1;
                currentMap.put(c, i);
            }
        }
        return answer;
    }
}