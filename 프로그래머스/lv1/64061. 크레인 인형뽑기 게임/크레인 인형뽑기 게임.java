import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            for (int[] e : board) {
                if (e[move - 1] != 0) {
                    if(stack.isEmpty()) {
                        stack.push(e[move - 1]);
                        e[move - 1] = 0;
                        break;
                    } else {
                        if(stack.peek() == e[move - 1]) {
                            e[move - 1] = 0;
                            stack.pop();
                            count += 2;
                            break;
                        } else {
                            stack.push(e[move - 1]);
                            e[move - 1] = 0;
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
}