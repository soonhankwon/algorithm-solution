import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed().sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < inputs.size() - 1; i++) {
            if (gcd(inputs.get(i), inputs.get(i + 1)) > 1) {
                ans.add(new int[]{inputs.get(i), inputs.get(i + 1)});
            }
        }
        int count = 0;
        for (int[] pair : ans) {
            int a = pair[0];
            int b = pair[1];

            for(int j = a + 1; j < b; j++) {
                int tmp = 0;

                if(gcd(a, j) == 1) {
                    tmp++;
                }
                if(gcd(b, j) == 1) {
                    tmp++;
                }
                if(tmp > 1) {
                    count++;
                    break;
                }
                if(j == b - 1) {
                    count += 2;
                }
            }
        }
        System.out.println(count);
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}