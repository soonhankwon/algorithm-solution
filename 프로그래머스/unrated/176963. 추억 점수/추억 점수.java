import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        int nameLength = name.length;
        for (int i = 0; i < nameLength; i++) {
            map.put(name[i], yearning[i]);
        }
        int tempSum = 0;
        List<Integer> answer = new ArrayList<>();
        for (String[] p : photo) {
            int pLength = p.length;
            for (int i = 0; i < pLength; i++) {
                if (!map.containsKey(p[i])) {
                    continue;
                }
                tempSum += map.get(p[i]);
            }
            answer.add(tempSum);
            tempSum = 0;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}