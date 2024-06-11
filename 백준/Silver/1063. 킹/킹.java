import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

    static Point curKingLocation, curStoneLocation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Point> map = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            char row = 'A';
            for (int j = 0; j < 8; j++) {
                String key = Character.toString(row + j) + (8 - i);
                map.put(key, new Point(i, j));
            }
        }

        String[] locationInfo = br.readLine().split(" ");
        curKingLocation = map.get(locationInfo[0]);
        curStoneLocation = map.get(locationInfo[1]);
        int n = Integer.parseInt(locationInfo[2]);

        for (int i = 0; i < n; i++) {
            move(br.readLine());
        }

        Set<Entry<String, Point>> entries = map.entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Point> entry : entries) {
            if (entry.getValue().equals(curKingLocation)) {
                sb.append(entry.getKey()).append("\n");
            }
        }
        for (Map.Entry<String, Point> entry : entries) {
            if (entry.getValue().equals(curStoneLocation)) {
                sb.append(entry.getKey());
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static void move(String operation) {
        Point kingMove = getNewPosition(curKingLocation, operation);
        if (isMovable(kingMove)) {
            if (kingMove.equals(curStoneLocation)) {
                Point stoneMove = getNewPosition(curStoneLocation, operation);
                if (isMovable(stoneMove)) {
                    curKingLocation = kingMove;
                    curStoneLocation = stoneMove;
                }
            } else {
                curKingLocation = kingMove;
            }
        }
    }

    private static Point getNewPosition(Point current, String operation) {
        int x = current.x;
        int y = current.y;
        switch (operation) {
            case "R":
                return new Point(x, y + 1);
            case "L":
                return new Point(x, y - 1);
            case "B":
                return new Point(x + 1, y);
            case "T":
                return new Point(x - 1, y);
            case "RT":
                return new Point(x - 1, y + 1);
            case "LT":
                return new Point(x - 1, y - 1);
            case "RB":
                return new Point(x + 1, y + 1);
            case "LB":
                return new Point(x + 1, y - 1);
        }
        return current;
    }

    private static boolean isMovable(Point point) {
        return point.x >= 0 && point.x < 8 && point.y >= 0 && point.y < 8;
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(new int[]{x, y});
        }
    }
}
