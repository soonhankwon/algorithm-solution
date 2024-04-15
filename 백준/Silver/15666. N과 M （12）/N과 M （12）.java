import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, m;
    static int[] arr;
    static StringBuilder sb;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = inputs[0];
        m = inputs[1];

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .distinct()
                .sorted()
                .toArray();

        sb = new StringBuilder();
        visited = new boolean[n];
        recursion(0, 0, "");
        System.out.println(sb);
        sb.setLength(0);
        br.close();
    }

    private static void recursion(int index, int depth, String str) {
        if (depth == m) {
            String combination = str.trim();
            sb.append(combination).append("\n");
            return;
        }

        int length = arr.length;
        for (int i = index; i < length; i++) {
            recursion(i, depth + 1, str + arr[i] + " ");
        }
    }
}
