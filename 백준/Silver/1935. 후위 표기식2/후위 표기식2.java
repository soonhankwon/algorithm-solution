import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String exp = br.readLine();
        double[] arr = new double[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Stack<Double> stack = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (c != '+' && c != '-' && c != '*' && c != '/') {
                stack.push(arr[c - 'A']);
            } else {
                double op2 = stack.pop();
                double op1 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(op1 + op2);
                        break;
                    case '-':
                        stack.push(op1 - op2);
                        break;
                    case '*':
                        stack.push(op1 * op2);
                        break;
                    case '/':
                        stack.push(op1 / op2);
                        break;
                }
            }
        }
        System.out.printf("%.2f\n", stack.peek());
        br.close();
    }
}
