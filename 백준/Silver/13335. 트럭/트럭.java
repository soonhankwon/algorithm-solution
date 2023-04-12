import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Truck's number
        int w = scanner.nextInt(); // Bridge's length
        int L = scanner.nextInt(); // Bridge's max weight

        Bridge bridge = new Bridge(w, L, new LinkedList<>());

        Queue<Truck> waitingQueue = IntStream.range(0, n)
                .mapToObj(i -> new Truck(scanner.nextInt(), 0))
                .collect(Collectors.toCollection(LinkedList::new));

        int time = 0;
        int totalWeight = 0;
        while (!waitingQueue.isEmpty() || !bridge.isEmpty()) {
            time++;
            if (!bridge.isEmpty()) {
                Truck frontTruck = bridge.getFrontTruck();
                if (time - frontTruck.getEnterTime() == w) {
                    totalWeight -= frontTruck.getWeight();
                    bridge.poll();
                }
            }

            if (!waitingQueue.isEmpty() && totalWeight + waitingQueue.peek().getWeight() <= L) {
                Truck truck = waitingQueue.poll();
                totalWeight += truck.getWeight();
                bridge.offer(truck, time);
            }
        }
        System.out.println(time);
    }
}

class Truck {
    private final int weight;
    private int enterTime;

    public Truck(int weight, int enterTime) {
        this.weight = weight;
        this.enterTime = enterTime;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getEnterTime() {
        return this.enterTime;
    }

    public void setEnterTime(int enterTime) {
        this.enterTime = enterTime;
    }
}

class Bridge {
    private final int length;
    private final int maxWeight;
    private final Queue<Truck> queue;

    private int currentWeight;

    public Bridge(int length, int maxWeight, Queue<Truck> queue) {
        this.length = length;
        this.maxWeight = maxWeight;
        this.queue = queue;
    }

    public void offer(Truck truck, int enterTime) {
        truck.setEnterTime(enterTime);
        queue.offer(truck);
        currentWeight += truck.getWeight();
    }

    public void poll() {
        Truck truck = queue.poll();
        currentWeight -= truck.getWeight();
    }

    public Truck getFrontTruck() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}