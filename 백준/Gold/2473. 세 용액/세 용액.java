import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력값이 1억 + 1억 + 1억 -> 결국 로그 시간복잡도로 풀어야 함
        // 파라메트릭 서치 - 투포인터
        // 1. 세 개의 다른 용액을 혼합하여 특성값이 최소인 용액은 얼마인가?
        // 2. 세 개의 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들수 있는가?
        // 세 종류의 알칼리 용액, 세 종류의 산성용액으로 만드는경우도 존재한다!!!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 데이터가 정렬되어야 함 nlogn(Tim sort)
        // eg) -99 -2 -1 4 98
        long[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();

        // two pointer -> 혼합 조합탐색 three pointer
        long min = Long.MAX_VALUE;
        long[] res = new long[3];
        // mid pointer move!
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = inputs.length - 1;

            while (start < end) {
                long sum = inputs[start] + inputs[i] + inputs[end];
                // 특성값이 0에 가장 가까운 용액 (절대값)
                long abs = Math.abs(sum);
                if (min > abs) {
                    min = abs;
                    res[0] = inputs[start];
                    res[1] = inputs[i];
                    res[2] = inputs[end];
                    if (sum == 0) {
                        break;
                    }
                }
                if (sum < 0) {
                    start++;
                    continue;
                }
                end--;
            }
        }

        Arrays.sort(res);
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
        br.close();
    }
}
