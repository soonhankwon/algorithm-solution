import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] aPattern = new int[]{1, 2, 3, 4, 5};
        int[] bPattern = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] cPattern = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] arr = new int[3];
        int max = 0;
        for(int i = 0; i < answers.length; i++) {
            if(aPattern[i % 5] == answers[i]) {
                arr[0]++;
                max = Math.max(max, arr[0]);
            } 
            if(bPattern[i % 8] == answers[i]) {
                arr[1]++;
                max = Math.max(max, arr[1]);
            } 
            if(cPattern[i % 10] == answers[i]) {
                arr[2]++;
                max = Math.max(max, arr[2]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(arr[i] == max) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}