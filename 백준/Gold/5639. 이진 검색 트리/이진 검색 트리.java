import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Binary Search Tree
public class Main {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while(true) {
            input = br.readLine();
            if(input == null || input.isEmpty()) {
                break;
            }
            root.insert(Integer.parseInt(input));
        }
        // 후위순회
        postTraversal(root);
        System.out.println(sb);
        br.close();
    }

    private static class Node {
        Node left, right;
        int val;

        Node(int val) {
            this.val = val;
        }

        void insert(int n) {
            if(n < this.val) {
                if(this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if(this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    private static void postTraversal(Node node) {
        if(node == null) {
            return;
        }
        postTraversal(node.left);
        postTraversal(node.right);
        sb.append(node.val).append("\n");
    }
}
