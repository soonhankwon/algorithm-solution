import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int countA = count(answer, a);
        int countB = count(answer, b);
        int countC = count(answer, c);

        int[] res = {countA, countB, countC};

        int max = Arrays.stream(res).max().orElse(0);
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 1;
        for (int r : res) {
            if(r == max)
                ans.add(i);
            i++;
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int count(int[] answer, int[] myAnswer) {
        int count = 0;
        int i = 0;
        for (int a : answer) {
            if (i >= myAnswer.length)
                i = 0;
            if (a == myAnswer[i]) {
                count++;
            }
            i++;
        }
        return count;
    }
}
