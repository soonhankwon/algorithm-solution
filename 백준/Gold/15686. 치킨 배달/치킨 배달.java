import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int[][] map;
    static int n, m;
    static List<Point> chickens, houses;
    static int minCityChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = inputs[0];
        m = inputs[1];
        map = new int[n][n];
        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < n; j++) {
                int pointData = row[j];
                map[i][j] = pointData;
                if (pointData == 2) {
                    chickens.add(new Point(i, j));
                } else if (pointData == 1) {
                    houses.add(new Point(i, j));
                }
            }
        }

        int size = chickens.size();
        boolean[] visited = new boolean[size];
        combination(chickens, visited, 0, size, m);
        System.out.println(minCityChickenDistance);
        br.close();
    }

    private static void combination(List<Point> arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            List<Point> selectedChickens = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    selectedChickens.add(arr.get(i));
                }
            }
            minCityChickenDistance = Math.min(minCityChickenDistance, calculateCityChickenDistance(selectedChickens));
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private static int calculateCityChickenDistance(List<Point> selectedChickens) {
        int totalDistance = 0;
        for (Point house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (Point chicken : selectedChickens) {
                int distance = house.calculateDistance(chicken);
                minDistance = Math.min(minDistance, distance);
            }
            totalDistance += minDistance;
        }
        return totalDistance;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int calculateDistance(Point point) {
            return Math.abs(this.x - point.x) + Math.abs(this.y - point.y);
        }
    }
}