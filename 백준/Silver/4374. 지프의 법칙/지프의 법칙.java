import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    static Pattern pattern = Pattern.compile("[\\W_]+");
    static final String END_SIGNAL = "EndOfText";
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                n = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                break;
            }
            List<String> words = new ArrayList<>();
            while (true) {
                String str = br.readLine();
                if (str.equals(END_SIGNAL)) {
                    break;
                }
                String[] row = pattern.split(str);
                for (String s : row) {
                    if (!s.isBlank() && s.length() > 1) {
                        words.add(s.toLowerCase());
                    }
                }
            }

            TreeMap<String, Long> treeMap = words.stream()
                    .collect(
                            Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting())
                    );
            List<String> res = treeMap.entrySet().stream()
                    .filter(e -> e.getValue() == n)
                    .map(Entry::getKey)
                    .collect(Collectors.toList());

            if (!res.isEmpty()) {
                res.forEach(s -> sb.append(s).append("\n"));
            } else {
                sb.append("There is no such word.").append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}