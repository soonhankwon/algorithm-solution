import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = inputs[0];
        m = inputs[1];
        int[] inputs2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        br.close();
        arr = new int[m];
        visited = new boolean[n];
        dfs(0, inputs2);
    }

    private static void dfs(int depth, int[] input) {
        StringBuffer sb = new StringBuffer();
        if(depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = input[i];
                dfs(depth + 1, input);
                visited[i] = false;
            }
        }

    }
}