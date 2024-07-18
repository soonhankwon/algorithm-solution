import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String[] START_LINES = {
            "\"재귀함수가 뭔가요?\"",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
    };

    private static final String[] ENDING_LINES = {
            "\"재귀함수는 자기 자신을 호출하는 함수라네\"",
            "라고 답변하였지."
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        recursion(n, 0, sb);
        System.out.println(sb);
        br.close();
    }

    private static void recursion(int n, int depth, StringBuilder sb) {
        String indent = "____".repeat(depth);

        // 재귀 질문 출력
        sb.append(indent).append(START_LINES[0]).append("\n");

        // 재귀 종료
        if (depth == n) {
            for (String line : ENDING_LINES) {
                sb.append(indent).append(line).append("\n");
            }
        } else {
            // 재귀 케이스
            for (int i = 1; i < START_LINES.length; i++) {
                sb.append(indent).append(START_LINES[i]).append("\n");
            }
            recursion(n, depth + 1, sb);
            sb.append(indent).append("라고 답변하였지.\n");
        }
    }
}
