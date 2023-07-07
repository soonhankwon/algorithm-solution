import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        ArrayList<Process> processes = new ArrayList<>();
        int sequence = 0;
        for (int[] job : jobs) {
            processes.add(new Process(++sequence, job[0], job[1]));
        }

        PriorityQueue<Process> diskController = new PriorityQueue<>();
        int spendingTime = 0;
        int time = 0;
        diskController.add(processes.get(0));
        processes.remove(0);
        while (!diskController.isEmpty() || !processes.isEmpty()) {
            if (diskController.peek() == null) {
                Iterator<Process> iterator = processes.iterator();
                while (iterator.hasNext()) {
                    Process p = iterator.next();
                    if (p.getStartTime() <= time) {
                        diskController.add(p);
                        iterator.remove();
                    }
                }
                if (diskController.peek() != null) {
                    continue;
                }
                time++;
                continue;
            }

            Process process = diskController.peek();
            if (process.getStartTime() <= time) {
                diskController.poll();
                spendingTime += (time - process.getStartTime() + process.getProcessingTime());
                time += process.getProcessingTime();
            } else {
                time++;
            }

            Iterator<Process> iterator = processes.iterator();
            while (iterator.hasNext()) {
                Process p = iterator.next();
                if (p.getId() == process.getId()) {
                    iterator.remove();
                    continue;
                }
                if (p.getStartTime() <= time) {
                    diskController.add(p);
                    iterator.remove();
                }
            }
        }

        return (int) Math.floor(spendingTime / jobs.length);
    }

    private static class Process implements Comparable<Process> {

        int id;
        int startTime;
        int processingTime;

        public Process(int id, int startTime, int processingTime) {
            this.id = id;
            this.startTime = startTime;
            this.processingTime = processingTime;
        }

        public int getId() {
            return this.id;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getProcessingTime() {
            return processingTime;
        }

        @Override
        public int compareTo(Process o) {
            return this.processingTime - o.processingTime;
        }
    }
}