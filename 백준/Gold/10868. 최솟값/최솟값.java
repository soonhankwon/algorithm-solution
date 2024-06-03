import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 범위 100,000 - 세그먼트 트리
 */
public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = inputs[0];
        int m = inputs[1];
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        Node node = Node.init(1, n);
        for (int i = 0; i < m; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int value = Node.getValue(node, row[0], row[1]);
            sb.append(value).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static class Node {
        int start;
        int end;
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int start, int end, int value) {
            this(start, end, value, null, null);
        }

        public Node(int start, int end, int value, Node leftChild, Node rightChild) {
            this.start = start;
            this.end = end;
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public static Node init(int left, int right) {
            // Leaf Node
            if (left == right) {
                return new Node(left, right, arr[left]);
            }
            // Parent Node
            int mid = (left + right) / 2;
            Node leftNode = init(left, mid);
            Node rightNode = init(mid + 1, right);
            return new Node(
                    left,
                    right,
                    Math.min(leftNode.value, rightNode.value),
                    leftNode,
                    rightNode
            );
        }

        private static int getValue(Node rootNode, int left, int right) {
            if (rootNode.start >= left && rootNode.end <= right) {
                return rootNode.value;
            }
            if (rootNode.start > right || rootNode.end < left) {
                return Integer.MAX_VALUE;
            }
            return Math.min(
                    getValue(rootNode.leftChild, left, right),
                    getValue(rootNode.rightChild, left, right)
            );
        }
    }
}
