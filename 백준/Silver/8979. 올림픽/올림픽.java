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
        CountryResult targetCountry = null;
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            CountryResult country = new CountryResult(row[0], row[1], row[2], row[3]);
            pq.add(country);
            if (country.id == k) {
                targetCountry = country;
            }
        }

        int currentRank = 0;
        int sameRankCount = 0;
        CountryResult prevCountry = null;
        while (!pq.isEmpty()) {
            CountryResult currentCountry = pq.poll();
            if (prevCountry == null || !currentCountry.isSameRank(prevCountry)) {
                currentRank += sameRankCount + 1;
                sameRankCount = 0;
            } else {
                sameRankCount++;
            }
            currentCountry.rank = currentRank;
            if (currentCountry == targetCountry) {
                System.out.println(currentCountry.rank);
                break;
            }
            prevCountry = currentCountry;
        }
        br.close();
    }

    private static class CountryResult implements Comparable<CountryResult> {
        int id;
        int gold;
        int silver;
        int bronze;
        int rank;

        public CountryResult(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        private boolean isSameRank(CountryResult countryResult) {
            return this.gold == countryResult.gold && this.silver == countryResult.silver
                    && this.bronze == countryResult.bronze;
        }

        @Override
        public int compareTo(CountryResult o) {
            if (this.gold != o.gold) {
                return o.gold - this.gold;
            } else if (this.silver != o.silver) {
                return o.silver - this.silver;
            } else {
                return o.bronze - this.bronze;
            }
        }
    }
}
