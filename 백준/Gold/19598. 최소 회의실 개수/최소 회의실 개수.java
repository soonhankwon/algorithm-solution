import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * n개의 회의를 모두 진행할 수 있는 "최소 회의실 개수"
         * 1회의실 - 1회의,  중간에 중단X
         * Input의 시간범위는 2^32-1 이므로 int
         * 해결법: Greedy 가장 빨리 비는 회의실을 찾아 배정
         * 1. 모든회의를 시작 시간 순으로 정렬
         * 2. 우선순위큐 - 현재 사용중인 회의실들의 종료시간만 모아둠(e.g. 큐에 종료시간이 2개인 경우 회의실 2개 사용중)
         * 3. 회의실 사용 가능 판단 로직
         * 3.1 가장 빨리 끝나는 회의의 종료 시간 <= 새로운 회의의 시작 시간 -> 회의실 재사용
         * 3.2 그렇지 않으면 새로운 회의실 필요
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[n];
        for(int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            meetings[i] = new Meeting(inputs[0], inputs[1]);
        }

        // 시작시간 기준 오름차순 정렬 O(NlogN)
        Arrays.sort(meetings, (m1, m2) -> {
            if(m1.start == m2.start) return Integer.compare(m1.end, m2.end);
            return Integer.compare(m1.start, m2.start);
        });

        // 종료시간 관리 우선순위큐 O(N)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Meeting m : meetings) {
            // 가장 빨리 끝나는 회의실이 비었는지 확인
            if(!pq.isEmpty() && pq.peek() <= m.start) {
                pq.poll(); // 회의실 재사용(종료시간 제거)
            }
            pq.add(m.end); // 새로운 회의의 종료시간 추가
        }

        System.out.println(pq.size());
        br.close();
    }

    static class Meeting {
        int start, end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
