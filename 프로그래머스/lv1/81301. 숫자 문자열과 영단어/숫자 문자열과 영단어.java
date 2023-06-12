import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        StringBuilder br = new StringBuilder();
        char[] chars = s.toCharArray();
        String key = "";
        for (char c : chars) {
            if (c > 47 && c < 58) {
                br.append(c);
            } else {
                key += c;
                if (map.containsKey(key)) {
                    br.append(map.get(key));
                    key = "";
                }
            }
        }
        return Integer.parseInt(br.toString());
    }
}