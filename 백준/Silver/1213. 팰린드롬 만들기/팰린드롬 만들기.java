import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

//팰린드롬
public class Main {
    // 1. 문자가 짝수개면 만들수 있다.
    // 2. 문자하나가 홀수 다른 문자가 짝수면 만들수 있다.
    // 앞문자열을 만들고 reverse -> 홀수개인 문자는 a + 홀수 + 리버스 a
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Map<String, Integer> map = new TreeMap<>();
        char[] chars = input.toCharArray();
        int cLength = chars.length;

        for (int i = 0; i < cLength; i++) {
            String key = String.valueOf(chars[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long oddCnt = map.keySet()
                .stream()
                .filter(k -> map.get(k) % 2 == 1)
                .count();

        String answer;
        if (oddCnt > 1) {
            answer = "I'm Sorry Hansoo";
            System.out.println(answer);
            return;
        }

        StringBuilder sb = new StringBuilder();
        String oddStr = "";
        if (oddCnt == 1) {
            oddStr = map.keySet()
                    .stream()
                    .filter(k -> map.get(k) % 2 == 1)
                    .findFirst()
                    .orElse(null);
        }
        map.keySet()
                .forEach(k -> {
                    Integer value = map.get(k);
                    sb.append(String.valueOf(k).repeat(Math.max(0, value / 2)));
                });
        String firstStr = sb.toString();
        String lastStr = sb.reverse().toString();
        System.out.println(firstStr + oddStr + lastStr);
        return;
    }
}
