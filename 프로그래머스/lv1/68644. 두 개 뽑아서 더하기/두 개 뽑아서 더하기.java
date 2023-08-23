import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
                if(i == j) continue;
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}