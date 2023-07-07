import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] operations) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String operation : operations) {
            String[] split = operation.split(" ");
            if (split[0].equals("I")) {
                numbers.add(Integer.valueOf(split[1]));
            } else {
                if (split[1].equals("-1")) {
                    if (numbers.isEmpty()) {
                        continue;
                    }
                    Integer min = numbers.stream().mapToInt(Integer::intValue).min().orElseThrow();
                    numbers.remove(min);
                } else {
                    if (numbers.isEmpty()) {
                        continue;
                    }
                    Integer max = numbers.stream().mapToInt(Integer::intValue).max().orElseThrow();
                    numbers.remove(max);
                }
            }
        }

        if(numbers.isEmpty()) {
            return new int[]{0,0};
        } else {
            int max = numbers.stream().mapToInt(Integer::intValue).max().orElseThrow();
            int min = numbers.stream().mapToInt(Integer::intValue).min().orElseThrow();

            return new int[] {max, min};
        }
    }
}
