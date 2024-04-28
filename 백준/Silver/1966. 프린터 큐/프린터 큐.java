import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<Document> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            queue = new LinkedList<>();
            int n = inputs[0];
            int targetId = inputs[1];

            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < n; j++) {
                queue.add(new Document(j, data[j]));
            }

            if (queue.size() == 1) {
                sb.append("1\n");
                continue;
            }

            int cnt = 0;
            while (!queue.isEmpty()) {
                Document poll = queue.poll();
                boolean important = isImportant(poll);

                if (important) {
                    cnt++;
                }

                if (poll.id == targetId && important) {
                    sb.append(cnt).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isImportant(Document poll) {
        int importance = poll.importance;
        for (Document document : queue) {
            if (document.getImportance() > importance) {
                queue.add(poll);
                return false;
            }
        }
        return true;
    }

    private static class Document {
        int id;
        int importance;

        public int getImportance() {
            return this.importance;
        }

        public Document(int id, int importance) {
            this.id = id;
            this.importance = importance;
        }
    }
}
