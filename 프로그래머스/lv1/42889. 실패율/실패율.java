import java.util.*;

class Solution {
    public static int[] solution(int N, int[] stages) {
        Map<Integer, Stage> map = new HashMap<>();
        Arrays.sort(stages);
        for (int i = 1; i <= N + 1; i++) {
            map.put(i, new Stage(i, 0, 0));
        }

        int gamers = stages.length;
        for (int i = 0; i < stages.length; i++) {
            int failStage = stages[i];
            Stage stage = map.get(failStage);
            if (i < stages.length - 1 && failStage != stages[i + 1]) {
                stage.increaseFailSum();
                stage.calculateFailRate(gamers);
                map.put(failStage, stage);
                gamers -= stage.getFailSum();
            } else if (i < stages.length - 1 && failStage == stages[i + 1]) {
                stage.increaseFailSum();
                map.put(failStage, stage);
            } else {
                if(stages[i] > N) {
                    break;
                }
                stage.increaseFailSum();
                stage.calculateFailRate(gamers);
                map.put(failStage, stage);
            }
        }

        int[] answer = new int[N];
        List<Map.Entry<Integer, Stage>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((e1, e2) -> Double.compare(e2.getValue().failRate, e1.getValue().failRate));
        for (int i = 0; i < N; i++) {
            answer[i] = entryList.get(i).getKey();
        }

        return answer;
    }

    public static class Stage {
        private int stageNumber;

        private int failSum;

        private double failRate;

        public Stage(int stageNumber, int failSum, double failRate) {
            this.stageNumber = stageNumber;
            this.failSum = failSum;
            this.failRate = failRate;
        }

        public void increaseFailSum() {
            this.failSum++;
        }

        public void calculateFailRate(int gamers) {
            if (gamers == 0)
                this.failRate = 0.0;
            else
                this.failRate = (double) this.failSum / gamers;
        }

        public int getFailSum() {
            return this.failSum;
        }
    }
}