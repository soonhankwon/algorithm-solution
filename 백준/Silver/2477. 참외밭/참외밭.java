import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
    static int[][] coordinates;
    static int k, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        coordinates = new int[6][2];
        for (int i = 0; i < 6; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int direction = row[0];
            int distance = row[1];
            movePoint(direction, distance);
            coordinates[i][0] = x;
            coordinates[i][1] = y;
        }
        int answer = calculateAreaByShoeLace();
        System.out.println(answer);
        br.close();
    }

    private static int calculateAreaByShoeLace() {
        int sum0 = 0;
        int sum1 = 0;
        for (int i = 0; i < 6; i++) {
            int xi = coordinates[i][0];
            int yi = coordinates[i][1];
            int xNext = coordinates[(i + 1) % 6][0];
            int yNext = coordinates[(i + 1) % 6][1];

            sum0 += xi * yNext;
            sum1 += yi * xNext;
        }
        return (Math.abs(sum0 - sum1) / 2) * k;
    }


    private static void movePoint(int direction, int distance) {
        if (direction == 1) {
            x += distance;
        } else if (direction == 2) {
            x -= distance;
        } else if (direction == 3) {
            y -= distance;
        } else {
            y += distance;
        }
    }
}
