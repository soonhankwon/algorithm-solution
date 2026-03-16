import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * 해결법: Greedy + 우선순위큐
         * 1. 데드라인 오름차순 정렬
         * 2. 수익 최소힙에 정렬된 강연을 넣음
         * 2.1 큐의 크기 > 강연 데드라인 = 최소힙에서 가장 수익이 적은 강연 포기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[n];
        for(int i = 0; i < n; i++){
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            lectures[i] = new Lecture(inputs[0], inputs[1]);
        }

        // 1. order by deadLine asc, pay desc
        Arrays.sort(lectures, (a, b) -> {
            if(a.deadLine == b.deadLine) return b.pay - a.pay;
            return a.deadLine - b.deadLine;
        });

        // 2. 수익 최소힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Lecture lecture : lectures) {
            pq.add(lecture.pay);

            // 큐의 크기(현재까지 잡힌 강연수)가 데드라인을 초과하면 가장 싼 강연 취소
            if(pq.size() > lecture.deadLine) pq.poll();
        }

        System.out.println(
                pq.stream().mapToInt(Integer::intValue).sum()
        );
        br.close();
    }

    private static class Lecture {
        int pay;
        int deadLine;
        Lecture(int pay, int deadLine) {
            this.pay = pay;
            this.deadLine = deadLine;
        }
    }
}
