import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 길이가 N인 정수 배열 A, B
        int[] a = new int[n];
        int[] b = new int[n];

        String[] aInputs = br.readLine().split(" ");
        String[] bInputs = br.readLine().split(" ");
        br.close();
        IntStream.range(0, n).forEach(i -> {
            a[i] = Integer.parseInt(aInputs[i]);
            b[i] = Integer.parseInt(bInputs[i]);
        });
      
        Arrays.sort(a);
        int[] reverseSortedB = IntStream.of(b)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int answer = IntStream.range(0, n).map(i -> (a[i] * reverseSortedB[i])).sum();
        System.out.println(answer);
    }
}