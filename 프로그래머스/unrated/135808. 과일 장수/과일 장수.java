import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int k, int m, int[] score) {
        int totalMinAppleScore = 0;
        int aBoxOfApples = m;

        Integer[] scores = Arrays.stream(score)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);
        
        for (int i = 1; i <= scores.length; i++) {
            if (i % aBoxOfApples == 0) {
                totalMinAppleScore += scores[i-1];
            }
        }
        return totalMinAppleScore * aBoxOfApples;
    }
}