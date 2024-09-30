import java.util.Arrays;
class Solution {
    public int[] solution(int n, int[] numlist) {
        numlist = Arrays.stream(numlist)
            .filter(i -> i % n == 0)
            .toArray();
        return numlist;
    }
}