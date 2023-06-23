import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int pickChance = nums.length / 2;
        int removedDuplicatesPocketMonNum = Arrays.stream(nums)
                .distinct()
                .toArray().length;

        return Math.min(pickChance, removedDuplicatesPocketMonNum);
    }
}