import java.util.*;

class Solution {
    
    private static int date;
    
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Progress> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(new Progress(progresses[i], speeds[i]));
        }

        ArrayList<Progress> result = new ArrayList<>();
        date = 0;
        while (!queue.isEmpty()) {
            updateAllProgressRate(queue);
            date++;
            releaseProgress(queue, result);
        }

        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        result.stream().mapToInt(Progress::getReleaseDate)
                .forEach(key -> map.put(key, map.getOrDefault(key, 0) + 1));

        return map.values().stream().mapToInt(Integer::intValue).toArray();
    }
    
    private static void releaseProgress(Queue<Progress> queue, ArrayList<Progress> result) {
        Progress priorityProgress = queue.peek();
        if (isProgressCanRelease(queue)) {
            priorityProgress.setReleaseDate(date);
            queue.poll();
            result.add(priorityProgress);
            releaseProgress(queue, result);
        }
    }
    
    private static void updateAllProgressRate(Queue<Progress> queue) {
        queue.iterator().forEachRemaining(Progress::updateProgressRate);
    }

    private static boolean isProgressCanRelease(Queue<Progress> queue) {
        return !queue.isEmpty() && queue.peek().getProgressRate() == 100;
    }

    private static class Progress {
        private int progressRate;
        private final int speed;

        private int releaseDate;

        public Progress(int progressRate, int speed) {
            this.progressRate = progressRate;
            this.speed = speed;
        }

        public int getProgressRate() {
            return progressRate;
        }

        public int getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(int releaseDate) {
            this.releaseDate = releaseDate;
        }

        public void updateProgressRate() {
            this.progressRate += speed;
            if (this.progressRate >= 100) {
                this.progressRate = 100;
            }
        }
    }
}