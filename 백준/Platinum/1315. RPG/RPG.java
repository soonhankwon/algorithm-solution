import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] questCount = new int[1001][1001];  // 각 스탯별로 클리어 가능한 퀘스트 수 저장
    static boolean[][] dp = new boolean[1001][1001];  // 해당 스탯에 도달 가능한지 저장
    static int[][] remainPoints = new int[1001][1001];   // 스탯 상승 후 남은 포인트 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] quests = new int[n][3];  // STR, INT, POINT 정보 저장

        // 퀘스트 정보 입력 받기 (STR, INT, POINT)
        for(int i = 0; i < n; i++) {
            quests[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        // 최대 스탯값 계산
        int maxStr = getMaxStat(quests, 1) + 1;  // 필요한 최대 힘 스탯
        int maxInt = getMaxStat(quests, 2) + 1;  // 필요한 최대 지능 스탯

        // 시작 상태 설정 - 초기 스탯(1,1) 방문 표시
        dp[1][1] = true;

        // 가능한 모든 스탯 조합 탐색
        for (int strStat = 1; strStat < maxStr; strStat++) {
            for (int intStat = 1; intStat < maxInt; intStat++) {
                int pointSum = 0;  // 획득한 총 포인트
                int clearedQuests = 0;   // 클리어한 퀘스트 수
                // 현재 스탯으로 클리어 가능한 퀘스트 확인
                for (int[] quest : quests) {
                    if (strStat >= quest[0] || intStat >= quest[1]) {
                        pointSum += quest[2];  // 퀘스트 클리어 보상 획득
                        clearedQuests++;
                    }
                }
                // 현재 스탯에서의 상태 저장
                questCount[strStat][intStat] = clearedQuests;
                remainPoints[strStat][intStat] = pointSum - (strStat - 1) - (intStat - 1);
                // 이전 상태에서 현재 상태로의 전이 가능성 확인
                if (strStat > 1 && dp[strStat-1][intStat] && remainPoints[strStat-1][intStat] > 0) {
                    dp[strStat][intStat] = true;
                }
                if (intStat > 1 && dp[strStat][intStat-1] && remainPoints[strStat][intStat-1] > 0) {
                    dp[strStat][intStat] = true;
                }
            }
        }
        System.out.println(getMaxClearedQuests(maxStr, maxInt));
        br.close();
    }

    static int getMaxStat(int[][] quests, int dimension) {
        int maxStat = 0;
        // dimension 1이면 힘(STR), 2면 지능(INT) 스탯 확인
        for (int[] quest : quests) {
            maxStat = Math.max(maxStat, quest[dimension - 1]);
        }
        return maxStat;
    }

    static int getMaxClearedQuests(int maxStr, int maxInt) {
        int maxCleared = 0;
        // 모든 가능한 스탯 조합 중 최대 클리어된 퀘스트 수 찾기
        for (int strStat = 1; strStat < maxStr; strStat++) {
            for (int intStat = 1; intStat < maxInt; intStat++) {
                if (dp[strStat][intStat]) {
                    maxCleared = Math.max(maxCleared, questCount[strStat][intStat]);
                }
            }
        }
        return maxCleared;
    }
}