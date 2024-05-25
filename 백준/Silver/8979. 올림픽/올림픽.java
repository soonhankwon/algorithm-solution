import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0];
        int k = inputs[1];
        PriorityQueue<CountryResult> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            pq.add(new CountryResult(row[0], row[1], row[2], row[3]));
        }
        int nowCountryId = 0;
        int index = 1;
        CountryResult cr = pq.peek();
        while (nowCountryId != k && !pq.isEmpty()) {
            CountryResult nowCountryResult = pq.poll();
            nowCountryId = nowCountryResult.id;
            if (cr.isSamePlace(nowCountryResult)) {
                index++;
            }
        }
        System.out.println(index);
        br.close();
    }

    private static class CountryResult implements Comparable<CountryResult> {
        int id;
        int gold;
        int silver;
        int bronze;

        public CountryResult(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public boolean isSamePlace(CountryResult countryResult) {
            return this.gold == countryResult.gold && this.silver == countryResult.silver
                    && this.bronze == countryResult.bronze;
        }

        @Override
        public int compareTo(CountryResult o) {
            if (this.gold == o.gold && this.silver == o.silver) {
                return -1 * (this.bronze - o.bronze);
            }
            if (this.gold == o.gold) {
                return -1 * (this.silver - o.silver);
            }
            return -1 * (this.gold - o.gold);
        }
    }
}
