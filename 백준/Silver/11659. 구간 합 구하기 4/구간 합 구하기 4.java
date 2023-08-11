import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split1 = br.readLine().split(" ");
        int n = Integer.parseInt(split1[0]);
        int m = Integer.parseInt(split1[1]);

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixSum[i] = nums[i];
                continue;
            }
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < m; i++) {
            int[] inputNums = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(num -> Integer.parseInt(num) - 1)
                    .toArray();

            if (inputNums[0] == 0)
                System.out.println(prefixSum[inputNums[1]]);
            else
                System.out.println(prefixSum[inputNums[1]] - prefixSum[inputNums[0] - 1]);
        }
        br.close();
    }
}