import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> map = new HashMap<>();
        for (String participant : participants) {
            map.put(participant, map.getOrDefault(participant, 0) + 1);
        }
        for (String completion : completions) {
            map.put(completion, map.get(completion) - 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) > 0)
                return key;
        }
        return "none";
    }
}