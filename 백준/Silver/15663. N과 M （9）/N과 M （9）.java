import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, m;
    static int[] inputArr, arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        n = Integer.parseInt(inputs[0]); //4
        m = Integer.parseInt(inputs[1]); //2

        inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(inputArr);
        //1 7 9 9

        //dfs 방문노드 체크 배열 초기화
        visited = new boolean[n + 1];

        //m 만큼만 출력해야되므로 크기 m으로 초기화
        arr = new int[m];
        dfs(0);
        br.close();
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        // 중복된것인지 체크하는 변수 eg) 1 -> 7,9,9 로 향할때 이전에 9가나왔으면 다음9는 패스해야함
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            if (temp != inputArr[i - 1]) {
                visited[i] = true;
                arr[depth] = inputArr[i - 1];
                temp = inputArr[i - 1];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
