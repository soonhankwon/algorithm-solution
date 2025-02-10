import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int[] par;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        par = new int[arr[0] + 1];
        for (int i = 0; i <= arr[0]; i++) {
            par[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr[1]; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (row[0] == 0) {
                union(row[1], row[2]);
            } else {
                if (checkSame(row[1], row[2])) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            par[b] = a;
        }
    }

    private static int find(int a) {
        if (par[a] == a) {
            return a;
        } else {
            return par[a] = find(par[a]);
        }
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }
}
