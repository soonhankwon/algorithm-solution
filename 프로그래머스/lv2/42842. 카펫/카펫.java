import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for(int i = 3; i < sum; i++) {
            int j = sum / i;

            if(sum % i == 0 && j >= 3) {
                int x = Math.max(i, j);
                int y = Math.min(i, j);
                int cen = (x - 2) * (y - 2);
                
                if(cen == yellow) {
                    answer[0] = x;
                    answer[1] = y;
                    return answer;
                }
            }
        }
        return answer;
    }
}