import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    static long max, maxCount, areaSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            areaSize = row[0];
            Map<Long, Long> map = Arrays.stream(row, 1, row.length)
                    .boxed()
                    .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

            max = 0;
            maxCount = 0;
            long maxKey = -1;
            Set<Entry<Long, Long>> entries = map.entrySet();
            for (Map.Entry<Long, Long> entry : entries) {
                // 병사들의 숫자
                long count = entry.getValue();
                // 병사들의 숫자가 최대값보다 크다면 maxCount = 1, 키값 변경, 같다면 maxCount++
                if (count > max) {
                    max = count;
                    maxKey = entry.getKey();
                    maxCount = 1;
                } else if (count == max) {
                    maxCount++;
                }
            }
            sb.append(!isOccupied() ? "SYJKGW" : maxKey).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isOccupied() {
        return maxCount == 1 && max > areaSize / 2;
    }
}
