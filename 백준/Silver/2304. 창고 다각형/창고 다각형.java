import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Pillar> queue = new PriorityQueue<>(Comparator.comparingInt(o -> -o.location));
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            queue.add(new Pillar(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }

        int[] pillars = new int[Objects.requireNonNull(queue.peek()).location];
        while (!queue.isEmpty()) {
            Pillar poll = queue.poll();
            pillars[poll.location - 1] = poll.height;
        }

        int maxHeight = Arrays.stream(pillars).max().orElseThrow();

        int[] prefixSum = new int[pillars.length + 1];
        int tempHeight = 0;
        for (int i = 0; i < pillars.length; i++) {
            if (tempHeight <= pillars[i]) {
                prefixSum[i + 1] = prefixSum[i] + pillars[i];
                tempHeight = pillars[i];
            } else {
                if(tempHeight == maxHeight) {
                    int secondMax = Integer.MIN_VALUE;
                    for(int j = i; j < pillars.length; j++) {
                        if(secondMax <= pillars[j]) {
                            secondMax = pillars[j];
                        }
                    }
                    prefixSum[i + 1] += prefixSum[i] + secondMax;
                } else {
                    prefixSum[i + 1] += prefixSum[i] + tempHeight;
                }
            }
        }
        
        System.out.println(prefixSum[prefixSum.length - 1]);
    }

    private static class Pillar {
        private int location;
        private int height;

        public Pillar(int location, int height) {
            this.location = location;
            this.height = height;
        }
    }
}