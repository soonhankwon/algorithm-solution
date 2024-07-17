import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        int n = (int) inputs[0];
        long target = inputs[1];

        int[] row = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int startPointer = 0, endPointer = 0;
        int answer = 0;
        long sum = 0;
        while (endPointer < n) {
            if (sum < target) {
                sum += row[endPointer++];
            }
            while (sum > target && startPointer < endPointer) {
                sum -= row[startPointer++];
            }
            if (sum == target) {
                answer++;
                sum -= row[startPointer++];
            }
        }
        System.out.println(answer);
        br.close();
    }
}
