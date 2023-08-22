import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Double> scores = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            scores.add(Double.parseDouble(br.readLine()));
            scores.sort(Comparator.naturalOrder());
            if (scores.size() > 7) {
                scores.remove(scores.get(scores.size() - 1));
            }
        }
        br.close();
        scores.forEach(i -> System.out.printf("%.3f%n", i));
    }
}