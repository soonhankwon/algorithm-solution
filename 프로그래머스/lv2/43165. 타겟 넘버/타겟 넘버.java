class Solution {
    
    static int count;
    static int targetNumber;
    
    public int solution(int[] numbers, int target) {
        count = 0;
        targetNumber = target;
        dfs(numbers[0], numbers, 1);
        dfs(-numbers[0], numbers, 1);
        return count;
    }
    
    private static void dfs(int sum, int[] numbers, int depth) {
        if (isNotTargetNumber(numbers)) {
            return;
        }
        
        if (isDepthFloor(numbers, depth)) {
            if (isSumTargetNumber(sum, targetNumber)) {
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
        return isSumTargetNumber(depth, numbers.length);
    }

    private static boolean isSumTargetNumber(int sum, int targetNumber) {
        return sum == targetNumber;
    }
}