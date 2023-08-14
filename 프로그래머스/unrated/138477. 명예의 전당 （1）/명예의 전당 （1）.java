import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> hallOfFame = new PriorityQueue<>();
        for (int i : score) {
            if(hallOfFame.size() > k - 1) {
                if(hallOfFame.peek() != null && i < hallOfFame.peek()) {
                    result.add(hallOfFame.peek());
                } else {
                    hallOfFame.add(i);
                    hallOfFame.remove(hallOfFame.peek());
                    result.add(hallOfFame.peek());
                }
            } else {
                hallOfFame.add(i);
                result.add(hallOfFame.peek());
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}