import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int length = arr.length;
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            boolean isMen = isMen(inputs[0]);
            int index = inputs[1];
            //AND - two pointer
            if (!isMen) {
                palindromeAndOperation(index - 1);
                continue;
            }
            for (int j = 1; j <= length; j++) {
                if (j % index == 0) {
                    //XOR
                    arr[j - 1] = arr[j - 1] ^ 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= length; i++) {
            int element = arr[i - 1];
            if (i == length) {
                sb.append(element);
                break;
            }
            if (i % 20 == 0) {
                sb.append(element);
                sb.append("\n");
                continue;
            }
            sb.append(element).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    private static void palindromeAndOperation(int mid) {
        int indexLeft = mid - 1; //1
        int indexRight = mid + 1; //3
        arr[mid] = arr[mid] ^ 1;
        while (indexLeft >= 0 && indexRight < n) {
            if (arr[indexLeft] == arr[indexRight]) {
                arr[indexLeft] = arr[indexLeft] ^ 1;
                arr[indexRight] = arr[indexRight] ^ 1;
                indexLeft--;
                indexRight++;
            } else {
                break;
            }
        }
    }

    private static boolean isMen(int num) {
        return num == 1;
    }
}
