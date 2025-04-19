import java.util.Stack;

class Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = 0;
        for(int i = 0; i < length; i++) {
            String rotatedStr = s.substring(i) + s.substring(0, i);
            // 괄호 검사를 위한 스택
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            
            for(char c : rotatedStr.toCharArray()) {
                if(c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if(stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    char top = stack.pop();
                    if((c == ')' && top != '(') || 
                       (c == '}' && top != '{') || 
                       (c == ']' && top != '[')) {
                        isValid = false;
                        break;
                    }
                }
            }
            if(isValid && stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}