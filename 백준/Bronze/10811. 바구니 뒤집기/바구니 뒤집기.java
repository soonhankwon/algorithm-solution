import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputLine1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = inputLine1[0];
        int m = inputLine1[1];

        List<String> baskets = new ArrayList<>();
        IntStream.rangeClosed(1, n).forEach(i -> baskets.add(String.valueOf(i)));

        for(int i = 0; i < m; i++) {
            int[] inputLine2 = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(b -> Integer.parseInt(b) - 1)
                    .toArray();
            List<String> subList = baskets.subList(inputLine2[0], inputLine2[1] + 1);
            Collections.reverse(subList);
        }

        baskets.forEach(i -> System.out.print(i + " "));
    }
}