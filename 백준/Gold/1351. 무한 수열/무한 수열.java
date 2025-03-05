import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    // Key: 수열의 인덱스, Value: 인덱스의 수열 값(메모이제이션)
    private static final Map<Long, Long> map = new HashMap<>();
    private static long p, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long n = arr[0];
        p = arr[1];
        q = arr[2];
        // 수열의 초기값: A[0] = 1
        map.put(0L, 1L);
        dfs(n);
        System.out.println(map.get(n));
        br.close();
    }

    /*
     * n을 p와 q로 나누면서 재귀적 계산 후 메모이제이션
     * e.g) A[10] = A[10/2] + A[10/3]
     */
    private static long dfs(long n) {
        // 이미 계산된 값이 있다면 리턴
        if (map.containsKey(n)) {
            return map.get(n);
        }
        long first = dfs((long) Math.floor((double) n / p));
        long second = dfs((long) Math.floor((double) n / q));
        map.put(n, first + second);
        return first + second;
    }
}