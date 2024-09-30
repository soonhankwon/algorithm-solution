import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}