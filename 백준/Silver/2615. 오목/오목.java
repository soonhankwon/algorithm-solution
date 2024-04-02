import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] map = new int[19][19];
    static int[] dx = {1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.arraycopy(inputs, 0, map[i], 0, 19);
        }

        // 완전탐색 - 오목찾기
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (map[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i;
                        int ny = j;
                        int cnt = 1; // 일치하는 바둑알 개수 체크

                        // 증가하는 방향 탐색
                        while (true) {
                            nx += dx[k];
                            ny += dy[k];
                            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                                if (map[i][j] == map[nx][ny]) {
                                    cnt++;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        nx = i;
                        ny = j;
                        // 반대 방향 탐색
                        while (true) {
                            nx -= dx[k];
                            ny -= dy[k];
                            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                                if (map[i][j] == map[nx][ny]) {
                                    cnt++;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        // 같은 오목눈이 5개라면
                        if (cnt == 5) {
                            System.out.println(map[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            br.close();
                            return;
                        }
                    }
                }
            }
        }
        // 아무도 이기지 않은 경우
        System.out.println(0);
        br.close();
    }
}
