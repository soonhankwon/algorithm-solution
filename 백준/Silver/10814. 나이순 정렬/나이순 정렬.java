import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Member> pq = new PriorityQueue<>(Comparator.comparingInt(Member::getAge)
                .thenComparing(m -> m.id));
        
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            int age = Integer.parseInt(inputs[0]);
            String name = inputs[1];
            pq.add(new Member(i, age, name));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Member member = pq.poll();
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static class Member {
        int id;
        int age;
        String name;

        public int getAge() {
            return this.age;
        }

        public Member(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }
    }
}
