import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        TreeMap<String, Long> map = input.chars()
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));

        long oddCnt = map.values()
                .stream()
                .filter(v -> v % 2 == 1)
                .count();

        if (oddCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        StringBuilder sb = new StringBuilder();
        String midStr = "";
        if (oddCnt == 1) {
            midStr = map.entrySet()
                    .stream()
                    .filter(e -> e.getValue() % 2 == 1)
                    .map(Entry::getKey)
                    .findFirst().orElse(null);
        }
        map.forEach((k, v) -> {
            sb.append(k.repeat((int) Math.max(0, v / 2)));
        });
        String firstStr = sb.toString();
        String lastStr = sb.reverse().toString();
        sb.setLength(0);
        sb.append(firstStr).append(midStr).append(lastStr);
        System.out.println(sb);
        br.close();
    }
}
