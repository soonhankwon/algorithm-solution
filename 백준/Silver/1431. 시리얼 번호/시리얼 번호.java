import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
            if (s1.length() > s2.length() || s1.length() < s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            }
            int sum1 = getSum(s1);
            int sum2 = getSum(s2);
            if (sum1 == sum2) {
                return s1.compareTo(s2);
            } else {
                return Integer.compare(sum1, sum2);
            }
        });
        for (int i = 0; i < n; i++) {
            pq.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int getSum(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }
}
