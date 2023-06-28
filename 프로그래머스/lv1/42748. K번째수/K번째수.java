import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> tempElements = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int[] command : commands) {
            int startIndex = command[0] - 1;
            int endIndex = command[1] - 1;
            for(int i = startIndex; i <= endIndex; i++) {
                tempElements.add(array[i]);
            }
            tempElements.sort(Comparator.naturalOrder());
            result.add(tempElements.get(command[2] - 1));
            tempElements.clear();
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}