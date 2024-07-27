import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<ArrayList<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(2, n) - 1;
        int[] row = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int h = (int) Math.ceil(Math.log(size) / Math.log(2)) + 1;
        tree = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            tree.add(new ArrayList<>());
        }

        buildTree(row, 0, size - 1, 0);
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Integer> level : tree) {
            for (Integer value : level) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void buildTree(int[] nodeValues, int start, int end, int depth) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        Node node = new Node(nodeValues[mid]);

        if (depth < tree.size()) {
            tree.get(depth).add(node.value);
        }

        buildTree(nodeValues, start, mid - 1, depth + 1);
        buildTree(nodeValues, mid + 1, end, depth + 1);
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}