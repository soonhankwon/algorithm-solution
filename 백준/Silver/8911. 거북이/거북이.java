import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 거북이 - 시뮬레이션
 * F, B (+1, -1)
 * L, R - 방향만 바꿈
 * 거북이가 지나간 영역을 모두 포함할 수 있는 가장 작은 직사각형의 넓이
 */
public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String operations = br.readLine();
            int length = operations.length();

            // 현재좌표와 초기 방향설정
            int minX = 0, minY = 0, maxX = 0, maxY = 0, nowX = 0, nowY = 0, dir = 0;
            for (int j = 0; j < length; j++) {
                char operation = operations.charAt(j);

                switch (operation) {
                    case 'F':
                        nowX += dx[dir];
                        nowY += dy[dir];
                        break;
                    case 'B':
                        nowX -= dx[dir];
                        nowY -= dy[dir];
                        break;
                    // 왼쪽으로 90도 회전
                    case 'L':
                        dir = (dir + 3) % 4;
                        break;
                    // 오른쪽으로 90도 회전
                    default:
                        dir = (dir + 1) % 4;
                        break;
                }

                minX = Math.min(minX, nowX);
                minY = Math.min(minY, nowY);
                maxX = Math.max(maxX, nowX);
                maxY = Math.max(maxY, nowY);
            }

            int sum = (Math.abs(minX) + Math.abs(maxX)) * (Math.abs(minY) + Math.abs(maxY));
            System.out.println(sum);
        }
        br.close();
    }
}
