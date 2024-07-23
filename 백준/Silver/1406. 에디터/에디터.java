import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static Stack<Character> leftStack = new Stack<>();
    static Stack<Character> rightStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine().chars().forEach(c -> leftStack.push((char) c));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            if (row.length == 1) {
                if (row[0].equals("L")) {
                    commandL();
                } else if (row[0].equals("B")) {
                    commandB();
                } else {
                    commandD();
                }
            } else {
                commandP(row[1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : leftStack) {
            sb.append(c);
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
        br.close();
    }

    private static void commandL() {
        if (!leftStack.empty()) {
            rightStack.push(leftStack.pop());
        }
    }

    private static void commandD() {
        if (!rightStack.empty()) {
            leftStack.push(rightStack.pop());
        }
    }

    private static void commandB() {
        if (!leftStack.empty()) {
            leftStack.pop();
        }
    }

    private static void commandP(String str) {
        str.chars().forEach(c -> leftStack.push((char) c));
    }
}