import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력값이 1억 + 1억 -> 결국 로그 시간복잡도로 풀어야 함
        // 파라메트릭 서치 - 투포인터
        // 1. 두 개의 다른 용액을 혼합하여 특성값이 최소인 용액은 얼마인가?
        // 2. 두 개의 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들수 있는가?
        // 두종류의 알칼리 용액, 두 종류의 산성용액으로 만드는경우도 존재한다!!!
        // -> 정렬후 앞, 뒤 인덱스의 값으로 해결하는 것은 불가능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        // 데이터가 정렬되어야 함 nlogn(Tim sort)
        // eg) -99 -2 -1 4 98
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        //two pointer -> 혼합 조합탐색
        int start = 0;
        int end = inputs.length - 1;
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];

        while (start < end) {
            int sum = inputs[start] + inputs[end];
            // 특성값이 0에 가장 가까운 용액 (절대값)
            int abs = Math.abs(sum);
            if (min > abs) {
                min = abs;
                res[0] = inputs[start];
                res[1] = inputs[end];
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
        System.out.println(res[0] + " " + res[1]);
        br.close();
    }
}
