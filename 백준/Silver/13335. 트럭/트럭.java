import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int w = inputs[1];
        int l = inputs[2];

        Bridge bridge = new Bridge(w, l);
        Queue<Truck> waitingQueue = Arrays.stream(br.readLine().split(" "))
                .map(i -> new Truck(Integer.parseInt(i), 0))
                .collect(Collectors.toCollection(LinkedList::new));

        int time = 0;
        int totalWeight = 0;
        Queue<Truck> bridgeQueue = bridge.queue;
        while (!waitingQueue.isEmpty() || !bridgeQueue.isEmpty()) {
            time++;
            if (!bridgeQueue.isEmpty()) {
                Truck frontTruck = bridgeQueue.peek();
                if (time - frontTruck.enterTime == w) {
                    totalWeight -= frontTruck.weight;
                    bridge.currentWeight -= frontTruck.weight;
                    bridgeQueue.poll();
                }
            }
            if (!waitingQueue.isEmpty() && totalWeight + waitingQueue.peek().weight <= l) {
                Truck truck = waitingQueue.poll();
                totalWeight += truck.weight;
                truck.enterTime = time;
                bridgeQueue.add(truck);
                bridge.currentWeight += truck.weight;
            }
        }
        System.out.println(time);
        br.close();
    }

    private static class Truck {
        int weight;
        int enterTime;

        public Truck(int weight, int enterTime) {
            this.weight = weight;
            this.enterTime = enterTime;
        }
    }

    private static class Bridge {
        int length;
        int maxWeight;
        int currentWeight;
        Queue<Truck> queue;

        public Bridge(int length, int maxWeight) {
            this.length = length;
            this.maxWeight = maxWeight;
            this.queue = new LinkedList<>();
        }
    }
}
