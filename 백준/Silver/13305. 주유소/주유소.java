import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 비용 최소화 -> 현재 선택지에서 싼 기름을 넣는 것(그리디)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dist = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] costs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long cost = 0;
        long min = costs[0];
        for (int i = 0; i < n - 1; i++) {
            // 현재 주유소가 이전 주유소의 가격보다 쌀 경우 갱신
            if (costs[i] < min) {
                min = Math.min(min, costs[i]);
            }
            cost += (min * dist[i]);
        }

        System.out.println(cost);
        br.close();
    }
}
