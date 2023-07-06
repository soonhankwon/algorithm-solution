import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> truckQueue = Arrays.stream(truck_weights)
                .mapToObj(Truck::new)
                .collect(Collectors.toCollection(LinkedList::new));

        int curBridgeMaxLoadWeight = weight;
        Queue<Truck> bridgeQueue = new LinkedList<>();
        int turn = 1;
        while(!truckQueue.isEmpty() || !bridgeQueue.isEmpty()) {
            if(truckQueue.peek() != null) {
                if(curBridgeMaxLoadWeight >= truckQueue.peek().getWeight()) {
                    Truck truck = truckQueue.poll();
                    bridgeQueue.add(truck);
                    curBridgeMaxLoadWeight -= truck.getWeight();
                }
            }
            bridgeQueue.iterator().forEachRemaining(Truck::move);
            if(bridgeQueue.stream().anyMatch(i -> i.getPosition() > bridge_length)) {
                Truck passedTruck = bridgeQueue.poll();
                curBridgeMaxLoadWeight += passedTruck.getWeight();
            }
            turn++;
        }

        return turn;
    }
    
    private static class Truck {
        private final int weight;
        private int position;

        public int getWeight() {
            return weight;
        }

        public int getPosition() {
            return position;
        }

        public void move() {
            this.position++;
        }

        public Truck(int weight) {
            this.weight = weight;
            this.position = 1;
        }
    }
}
