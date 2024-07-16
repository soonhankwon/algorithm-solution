import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Arrays.stream(row, 1, row.length).average()
                    .ifPresent(
                            avg -> {
                                long studentAboveAvgCnt = Arrays.stream(row, 1, row.length)
                                        .filter(r -> r > avg)
                                        .count();
                                double percentage = (double) studentAboveAvgCnt / row[0] * 100;
                                sb.append(String.format("%.3f%%\n", percentage));
                            }
                    );
        }
        System.out.println(sb);
        br.close();
    }
}
