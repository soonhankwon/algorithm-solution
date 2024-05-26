import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    static int[] unionFind;
    static List<LineSegment> lineSegments;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        lineSegments = new ArrayList<>();
        unionFind = new int[n + 1];
        IntStream.rangeClosed(1, n).forEach(i -> unionFind[i] = i);

        for (int i = 1; i <= n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            lineSegments.add(new LineSegment(row[0], row[1], row[2], row[3]));
        }

        int leftParent, rightParent;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                leftParent = find(i);
                rightParent = find(j);

                if (leftParent != rightParent) {
                    if (isCrossed(lineSegments.get(i - 1), lineSegments.get(j - 1))) {
                        union(i, j);
                    }
                }
            }
        }
        int[] cnt = new int[n + 1];
        int max = 0;
        int size = 0;
        for (int i = 1; i <= n; i++) {
            cnt[unionFind[i]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
            }
            if (cnt[i] != 0) {
                size++;
            }
        }
        System.out.println(size + "\n" + max + "\n");
        br.close();
    }

    private static int find(int num) {
        if (num == unionFind[num]) {
            return num;
        }
        return unionFind[num] = find(unionFind[num]);
    }

    private static void union(int num1, int num2) {
        num1 = find(num1);
        num2 = find(num2);
        if (num1 != num2) {
            unionFind[num1] = num2;
        }
    }

    private static boolean isCrossed(LineSegment line1, LineSegment line2) {
        long hasCheck1 = ccw(line1.x1, line1.y1, line1.x2, line1.y2, line2.x1, line2.y1) *
                ccw(line1.x1, line1.y1, line1.x2, line1.y2, line2.x2, line2.y2);
        long hasCheck2 = ccw(line2.x1, line2.y1, line2.x2, line2.y2, line1.x1, line1.y1) *
                ccw(line2.x1, line2.y1, line2.x2, line2.y2, line1.x2, line1.y2);

        if (hasCheck1 == 0 && hasCheck2 == 0) {
            return isOverlapped(line1, line2);
        }
        return hasCheck1 <= 0 && hasCheck2 <= 0;
    }

    private static boolean isOverlapped(LineSegment line1, LineSegment line2) {
        if (Math.max(line1.x1, line1.x2) < Math.min(line2.x1, line2.x2)) {
            return false;
        }
        if (Math.max(line2.x1, line2.x2) < Math.min(line1.x1, line1.x2)) {
            return false;
        }
        if (Math.max(line1.y1, line1.y2) < Math.min(line2.y1, line2.y2)) {
            return false;
        }
        return Math.max(line2.y1, line2.y2) >= Math.min(line1.y1, line1.y2);
    }

    private static long ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        // (x1y1+x2y3+x3y1) - (y1x2+y2x3+y3x1)
        long res = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        if (res == 0) {
            return 0;
        }
        return res > 0 ? 1 : -1;
    }

    private static class LineSegment {
        long x1;
        long y1;
        long x2;
        long y2;

        public LineSegment(long x1, long y1, long x2, long y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}
