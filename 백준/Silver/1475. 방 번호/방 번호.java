import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Map<Character, Long> map = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c == '9' ? '6' : c, Collectors.counting()));

        long sixNineCnt = map.getOrDefault('6', 0L);
        long sixNineSetCnt = (sixNineCnt + 1) / 2; // 올림
        long maxOtherCnt = 0;
        Set<Entry<Character, Long>> entrySet = map.entrySet();
        for (Map.Entry<Character, Long> entry : entrySet) {
            if (entry.getKey() != '6') {
                maxOtherCnt = Math.max(maxOtherCnt, entry.getValue());
            }
        }

        System.out.println(Math.max(sixNineSetCnt, maxOtherCnt));
        br.close();
    }
}