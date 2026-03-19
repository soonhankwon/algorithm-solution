import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * 해결법: Two-Pointer + Sliding Window
         * 1. 카운트 배열: 윈도우 내에 각 숫자가 몇 번 등장했는지?
         * 2. left, right 포인터 이동하면서 카운팅
         * 3. right를 먼저 이동시키면 카운팅
         * 4. 카운트가 k를 초과하면, left를 이동하면서 카운트를 빼줌(불필요한 숫자 버림)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0];
        int k = inputs[1];

        int[] count = new int[100_001];
        int left = 0, right = 0, max = 0;
        while(right < n) {
            count[arr[right]]++;

            while(count[arr[right]] > k) {
                count[arr[left]]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        System.out.println(max);
        br.close();
    }
}
