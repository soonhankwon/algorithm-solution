import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            char[] operations = br.readLine().toCharArray();
            int minX = 0, minY = 0, maxX = 0, maxY = 0, nowX = 0, nowY = 0, dir = 0;

            for (int j = 0; j < operations.length; j++) {
                char operation = operations[j];
                if (operation == 'F') {
                    nowX += dx[dir];
                    nowY += dy[dir];
                } else if (operation == 'B') {
                    nowX -= dx[dir];
                    nowY -= dy[dir];
                } else if (operation == 'L') {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
                minX = Math.min(minX, nowX);
                minY = Math.min(minY, nowY);
                maxX = Math.max(maxX, nowX);
                maxY = Math.max(maxY, nowY);
            }
            int sum = (Math.abs(minX) + Math.abs(maxX)) * (Math.abs(minY) + Math.abs(maxY));
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
