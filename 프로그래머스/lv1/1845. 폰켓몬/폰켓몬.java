import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int pickChance = nums.length / 2;
        int removedDuplicatesPocketMonNum = Arrays.stream(nums)
                .distinct()
                .toArray().length;

        return Math.min(pickChance, removedDuplicatesPocketMonNum);
    }

    // Set
    private static int solutionV2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);

        return set.size() > nums.length / 2 ? nums.length / 2 : set.size();
    }

    // Short Coding
    private static int solutionV3(int[] nums) {
        return Math.min(nums.length / 2, Arrays.stream(nums).distinct().toArray().length);
    }
}
