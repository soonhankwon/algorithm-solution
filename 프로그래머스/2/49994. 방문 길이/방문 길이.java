import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        int[][] directions = {
                {0, 1},
                {0, -1},
                {-1, 0},
                {1, 0}
        };
        // 경로 방문여부(중복되면 안됨)
        Set<Path> visitedPaths = new HashSet<>();
        for (char dir : dirs.toCharArray()) {
            int dirIndex = "UDLR".indexOf(dir);
            int nx = x + directions[dirIndex][0];
            int ny = y + directions[dirIndex][1];
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }
            Path path = new Path(x, y, nx, ny);
            visitedPaths.add(path);
            x = nx;
            y = ny;
        }
        return visitedPaths.size();
    }
}

class Path {
        int x1, y1, x2, y2;
        public Path(int x1, int y1, int x2, int y2) {
            if (x1 < x2 || (x1 == x2 && y1 < y2)) {
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
            } else {
                this.x1 = x2;
                this.y1 = y2;
                this.x2 = x1;
                this.y2 = y1;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Path path = (Path) o;
            return x1 == path.x1 && y1 == path.y1 && x2 == path.x2 && y2 == path.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
}