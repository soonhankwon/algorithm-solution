import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        // 모두 VPS 인경우 스택은 텅 비어있어야 정상이다. () 는 짝을 이루어야 함!
        // ( 일때 push, ) 일때 pop
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String answer = executeStackOperation(br.readLine());
            System.out.println(answer);
            stack.clear();
        }
        br.close();
    }

    private static String executeStackOperation(String input) {
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
                continue;
            }
            // 스택이 비어있는 경우, 하지만 pop 할 요소'('가 없는 경우
            if (stack.empty()) {
                return "NO";
            }
            stack.pop();
        }

        /* 스택에 남는 요소가 있으면 NO
         * 비어있으면 YES
         */
        if (stack.empty()) {
            return "YES";
        }
        return "NO";
    }
}
