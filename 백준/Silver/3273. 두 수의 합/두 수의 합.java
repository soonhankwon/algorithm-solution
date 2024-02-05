import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        // eg) 1,2,3,5,7,9,10,11,12

        int x = Integer.parseInt(br.readLine());
        // two-pointer
        int index1 = 0;
        int index2 = n - 1;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (index1 >= index2) {
                break;
            }
            int sum = inputs[index1] + inputs[index2];
            if (sum > x) {
                index2--;
                continue;
            }
            if (sum < x) {
                index1++;
                continue;
            }
            answer++;
            index1++;
            index2--;
        }

        System.out.println(answer);
    }
}
