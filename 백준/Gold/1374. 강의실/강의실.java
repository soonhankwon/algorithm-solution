import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        // N개의 강의가 있다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            lectures.add(new Lecture(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }
        Collections.sort(lectures);
        br.close();

        // 그리디 알고리즘 적용, 강의시간이 빠른 순서대로 겹치지 않는 강의를 강의실 별로 구성한다.
        PriorityQueue<Integer> lectureClass = new PriorityQueue<>();
        int answer = 1;
        for (int i = 0; i < n; i++) {
            while (!lectureClass.isEmpty() && lectureClass.peek() <= lectures.get(i).startTime) {
                lectureClass.poll();
            }
            lectureClass.offer(lectures.get(i).endTime);
            answer = Math.max(answer, lectureClass.size());
        }

        System.out.println(answer);
    }

    private static class Lecture implements Comparable<Lecture> {
        private int startTime;
        private int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        // 강의 시간이 가장 적은 강의를 오름차순으로 정렬하도록
        @Override
        public int compareTo(Lecture o) {
            if (this.startTime == o.startTime) {
                return this.endTime - o.endTime;
            }
            return this.startTime - o.startTime;
        }
    }
}