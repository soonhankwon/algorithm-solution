import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(queue::add);

        int count = 0;
        while(queue.peek() != null && queue.peek() < K) {
            Integer first = queue.poll();
            if(queue.peek() == null) {
                return -1;
            }
            Integer second = queue.poll();
            int newScoville = first + (second * 2);
            queue.add(newScoville);
            count++;
        }

        return count;
    }
}