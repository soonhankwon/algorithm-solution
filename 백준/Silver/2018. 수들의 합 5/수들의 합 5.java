import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int startPointer = 1, endPointer = 1, sum = 1, answer = 1;
        while (startPointer != n) {
            if (sum < n) {
                endPointer++;
                sum += endPointer;
            } else if (sum > n) {
                sum -= startPointer;
                startPointer++;
            } else {
                answer++;
                endPointer++;
                sum += endPointer;
            }
        }
        System.out.println(answer);
        br.close();
    }
}