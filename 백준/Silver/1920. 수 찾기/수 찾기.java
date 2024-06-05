import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        br.readLine();
        StringBuilder sb = new StringBuilder();
        int[] row = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.stream(row)
                .map(num -> Arrays.binarySearch(arr, num) < 0 ? 0 : 1)
                .forEach(res -> sb.append(res).append("\n"));
        System.out.println(sb);
        br.close();
    }
}
