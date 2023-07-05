import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> processes = new LinkedList<>();
        int id = 0;
        for (int priority : priorities) {
            processes.add(new Process(id, priority));
            id++;
        }

        ArrayList<Process> result = new ArrayList<>();
        int index = 1;
        while (!processes.isEmpty()) {
            Process process = processes.poll();
            if (processes.stream().anyMatch(p -> process.getPriority() < p.getPriority())) {
                processes.add(process);
                index--;
            } else {
                process.setCompletedNumber(index);
                result.add(process);
            }
            index++;
        }

        return result.stream().filter(i -> i.getId() == location).findFirst().orElseThrow().getCompletedNumber();
    }
}
    
class Process {

    private int id;
    private int priority;
    private int completedNumber;

    public Process(int id, int priority) {
        this.id = id;
        this.priority = priority;
        this.completedNumber = 0;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public int getCompletedNumber() {
        return completedNumber;
    }

    public void setCompletedNumber(int completedNumber) {
        this.completedNumber = completedNumber;
    }
}