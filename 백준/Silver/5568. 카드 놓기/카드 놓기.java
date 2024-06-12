import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static int n, k;
    static Set<String> set;
    static List<String> arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(br.readLine());
        }
        set = new HashSet<>();
        // 각 숫자를 방문할 때 방문배열을 사용하여 다시 방문하지 않도록 함
        visited = new boolean[n];
        recursion(0, "");
        System.out.println(set.size());
        br.close();
    }

    private static void recursion(int depth, String str) {
        if (depth == k) {
            set.add(str);
            return;
        }
        // 모든 숫자를 고려
        for (int i = 0; i < n; i++) {
            // 방문여부를 체크해서 가능한 순열(문자열)을 생성
            if (!visited[i]) {
                visited[i] = true;
                recursion(depth + 1, str + arr.get(i));
                visited[i] = false;
            }
        }
    }
}
