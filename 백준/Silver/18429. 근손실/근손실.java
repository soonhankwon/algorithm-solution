import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static int n;
    static int k;
    static int count;
    static List<Integer> arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); //운동키트 갯수 & n 일
        k = scanner.nextInt(); //감소량

        arr = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> arr.add(scanner.nextInt()));
        arr.sort(Comparator.naturalOrder());

        visited = new boolean[n];
        count = 0;
        backTracking(500, 0);
        System.out.println(count);
    }

    private static void backTracking(int sum, int depth) {
        if (depth == n - 1) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && sum + arr.get(i) - k >= 500) {
                visited[i] = true;
                backTracking(sum + arr.get(i) - k, depth + 1);
                visited[i] = false;
            }
        }
    }
}