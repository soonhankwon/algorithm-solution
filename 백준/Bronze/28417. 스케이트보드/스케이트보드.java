import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int runHighScore = Math.max(row[0], row[1]);
            Arrays.sort(row, 2, row.length);
            answer = Math.max(answer, runHighScore + row[5] + row[6]);
        }
        System.out.println(answer);
        br.close();
    }
}
