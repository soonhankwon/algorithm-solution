import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] budgets = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int totalBudget = Integer.parseInt(br.readLine());
        int left = 0;
        int right = budgets[n - 1];
        int answer = Integer.MIN_VALUE;
        while (left <= right) {
            int tempSum = 0;
            int mid = (left + right) / 2;
            for (int budget : budgets) {
                tempSum += Math.min(budget, mid);
            }
            if (tempSum < totalBudget) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            } else if (tempSum == totalBudget) {
                answer = mid;
                break;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
