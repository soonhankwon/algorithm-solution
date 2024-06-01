import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

public class Main {

    private static Pattern pattern = Pattern.compile("#");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = inputs[0];
        int m = inputs[1];
        String[] verticalWords = new String[m];
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            Arrays.stream(pattern.split(row))
                    .filter(s -> s.length() > 1)
                    .forEach(pq::add);

            int length = row.length();
            for (int j = 0; j < length; j++) {
                verticalWords[j] = i == 0 ?
                        String.valueOf(row.charAt(j)) : verticalWords[j] + row.charAt(j);
            }
        }
        Arrays.stream(verticalWords)
                .flatMap(str -> Arrays.stream(pattern.split(str)))
                .filter(s -> s.length() > 1)
                .forEach(pq::add);

        System.out.println(pq.poll());
        br.close();
    }
}
