import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] tree = new int[26][2];

        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(in -> in.charAt(0) - 'A')
                    .toArray();
            int node = arr[0];
            int left = arr[1];
            int right = arr[2];

            tree[node][0] = left;
            tree[node][1] = right;
        }

        preOrder(tree, 0);
        sb.append("\n");
        inOrder(tree, 0);
        sb.append("\n");
        postOrder(tree, 0);
        System.out.println(sb);
        br.close();
    }

    private static void preOrder(int[][] tree, int node) {
        if (node == -19) {
            return;
        }
        sb.append((char) (node + 'A'));
        preOrder(tree, tree[node][0]);
        preOrder(tree, tree[node][1]);
    }

    private static void inOrder(int[][] tree, int node) {
        if (node == -19) {
            return;
        }
        inOrder(tree, tree[node][0]);
        sb.append((char) (node + 'A'));
        inOrder(tree, tree[node][1]);
    }

    private static void postOrder(int[][] tree, int node) {
        if (node == -19) {
            return;
        }
        postOrder(tree, tree[node][0]);
        postOrder(tree, tree[node][1]);
        sb.append((char) (node + 'A'));
    }
}
