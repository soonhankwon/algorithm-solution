import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stageCount = new int[N + 2];
        for(int stage : stages) {
            stageCount[stage]++;
        }
        int totalUsers = stages.length;
        PriorityQueue<Stage> pq = new PriorityQueue<>(
            (a, b) -> {
                if(Double.compare(b.failRate, a.failRate) != 0) {
                    return Double.compare(b.failRate, a.failRate);
                } else {
                    return Integer.compare(a.num, b.num);
                }
            }
        );
        for(int i = 1; i <= N; i++) {
            int count = stageCount[i];
            double failRate = totalUsers == 0 ? 0 : (double) count / totalUsers;
            pq.add(new Stage(i, failRate));
            totalUsers -= count;
        }
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = pq.poll().num;
        }
        return answer;
    }
    
    private class Stage {
        int num;
        double failRate;
        
        public Stage(int num, double failRate) {
            this.num = num;
            this.failRate = failRate;
        }
    }
}