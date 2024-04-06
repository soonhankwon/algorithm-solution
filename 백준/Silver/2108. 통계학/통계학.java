import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * 백준 - 2108 통계학
 * n은 홀수이다!
 * 1. 산술평균: (totalSum) / n <- 첫째짜리 반올림
 * 2. 중앙값: mid
 * 3. 최빈값: cnt
 * 4. 범위: min - max
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int[] arr = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
            map.put(input, map.getOrDefault(input, 0) + 1);
            sum += input;
        }

        Arrays.sort(arr);
        long arithmeticMean = Math.round((double) sum / n);
        int median = arr[n / 2];

        //mode -> 동일한 최빈값이 있을 경우 두번째로 작은값 출력
        int modeKey = 0;
        int modeValue = Integer.MIN_VALUE;
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if (map.get(key) > modeValue) {
                modeValue = map.get(key);
                modeKey = key;
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer key : keySet) {
            if (map.get(key) == modeValue) {
                pq.add(key);
            }
        }
        if (pq.size() > 1) {
            pq.poll();
        }
        assert pq.peek() != null;
        modeKey = pq.poll();

        int range = arr[arr.length - 1] - arr[0];
        String answer = arithmeticMean + "\n"
                + median + "\n"
                + modeKey + "\n"
                + range;
        System.out.println(answer);
        br.close();
    }
}
