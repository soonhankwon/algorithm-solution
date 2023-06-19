import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int element : arr) {
            if (stack.isEmpty()) {
                stack.add(element);
            }
            else {
                if (stack.peek() != element) {
                    stack.add(element);
                }
            }
        }

        return IntStream.rangeClosed(0, stack.size() - 1)
                .map(stack::get)
                .toArray();
    }
}