import java.util.Arrays;

class Solution {
    
    static int count;
    static int targetNumber;
    
    public int solution(int[] numbers, int target) {
        count = 0;
        targetNumber = target;
        Arrays.sort(numbers);
        if (isNotTargetNumber(numbers)) {
            return count;
        }
        dfs(numbers[0], numbers, 1);
        dfs(-numbers[0], numbers, 1);

        return count;
    }
    
    private static void dfs(int sum, int[] numbers, int depth) {
        if (isDepthFloor(numbers, depth)) {
            if (isSumTargetNumber(sum)) {
                count++;
            }
            return;
        }
        dfs(sum + numbers[depth], numbers, depth + 1);
        dfs(sum - numbers[depth], numbers, depth + 1);
    }

    private static boolean isNotTargetNumber(int[] numbers) {
        int first = numbers[0];
        int last = numbers[numbers.length - 1];
        return (int) Math.pow(first + last, 2) < targetNumber;
    }

    private static boolean isDepthFloor(int[] numbers, int depth) {
        return depth == numbers.length;
    }

    private static boolean isSumTargetNumber(int sum) {
        return sum == targetNumber;
    }
}
