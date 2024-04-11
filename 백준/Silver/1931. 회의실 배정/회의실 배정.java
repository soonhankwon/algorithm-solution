import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static int cnt, endTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            pq.add(new Meeting(inputs[0], inputs[1]));
        }

        endTime = -1;
        while (!pq.isEmpty()) {
            Meeting meeting = pq.poll();
            if (meeting.start >= endTime) {
                cnt++;
                endTime = meeting.end;
            }
        }
        System.out.println(cnt);
        br.close();
    }

    private static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        // 끝나는 시간이 같을 경우 시작시간 기준으로 정렬
        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
