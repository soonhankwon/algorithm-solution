import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heapTree = new int[n + 1];
        for (int i = 1; i < n; i++) {
            // 이진 트리 부모 인덱스 연산 n/2
            for (int j = i; j > 1; j /= 2) {
                heapTree[j] = heapTree[j / 2]; // SWAP
            }
            heapTree[1] = i + 1; // 루트노드에 최대값 입력
        }

        heapTree[n] = 1; //최소값 마지막 노드에 추가
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(heapTree[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
