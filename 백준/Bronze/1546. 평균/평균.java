import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> scores = new ArrayList<>();
        String[] split = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            scores.add(Integer.parseInt(split[i]));
        }
        double max = scores.stream().mapToInt(Integer::intValue).max().orElse(0);
        double sum = scores.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(((sum / max) * 100) / n);
    }
}