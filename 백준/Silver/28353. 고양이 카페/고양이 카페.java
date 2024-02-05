import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int n = inputs[0];
        int k = inputs[1];

        // 오름차순으로 정렬
        int[] inputs2 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();
        // eg) 3, 4, 5, 6, 7, 9
        int answer = 0;
        // two-pointer
        int index1 = 0;
        int index2 = n - 1;
        for (int i = 0; i < n; i++) {
            if (index1 >= index2) {
                break;
            }
            int sum = inputs2[index1] + inputs2[index2];
            if (sum > k) {
                index2--;
                continue;
            }
            index1++;
            index2--;
            answer++;
        }
        System.out.println(answer);
    }
}
