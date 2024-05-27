import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 분자수열 1 | 1 2 | 3 2 1 | 1 2 3 4 | 5 4 3 2 1
        // 분모수열 1 | 2 1 | 1 2 3 | 4 3 2 1 | 1 2 3 4 5
        int sum = 0;
        int index = 0;
        while (sum < n) {
            index++;
            sum += index;
        }
        int position = n - (sum - index);
        int numerator, denominator;
        // 대각선이 짝수인 경우
        if (index % 2 == 0) {
            numerator = position;
            denominator = index - position + 1;
        } else {
            numerator = index - position + 1;
            denominator = position;
        }
        System.out.println(numerator + "/" + denominator);
        br.close();
    }
}