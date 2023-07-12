import java.util.ArrayList;

class Solution {
    
    static ArrayList<Dungeon> dungeonList;
    static boolean[] visited;
    static int count;
    static int maxCount;
    static int playEnergy;
    
    public int solution(int k, int[][] dungeons) {
       dungeonList = new ArrayList<>();
        for (int[] dungeon : dungeons) {
            dungeonList.add(new Dungeon(dungeon[0], dungeon[1]));
        }

        playEnergy = k;
        visited = new boolean[dungeons.length];
        count = 0;
        maxCount = 0;
        dfs(0);
        return maxCount;
    }

    private static void dfs(int depth) {
        if (depth == dungeonList.size()) {
            maxCount = Math.max(maxCount, count);
            return;
        }

        for (int i = 0; i < dungeonList.size(); i++) {
            if (!visited[i]) {
                if (dungeonList.get(i).requiredEnergy > playEnergy) {
                    continue;
                } else {
                    visited[i] = true;
                    count++;
                    playEnergy -= dungeonList.get(i).consumedEnergy;
                    dfs(depth + 1);
                    visited[i] = false;
                    count--;
                    playEnergy += dungeonList.get(i).consumedEnergy;
                }
            } else {
                dfs(depth + 1);
            }
        }
    }

    private static class Dungeon {
        private int requiredEnergy;
        private int consumedEnergy;

        public Dungeon(int requiredEnergy, int consumedEnergy) {
            this.requiredEnergy = requiredEnergy;
            this.consumedEnergy = consumedEnergy;
        }
    }
}