import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<TeamMate> teamMates = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String[] row = br.readLine().split(" ");
            teamMates.add(
                    new TeamMate(
                            Integer.parseInt(row[1]) - 2000,
                            row[2],
                            Integer.parseInt(row[0])
                    )
            );
        }
        StringBuilder sb = new StringBuilder();
        teamMates.sort(Comparator.comparingInt(i -> i.birth));
        teamMates.forEach(i -> sb.append(i.birth));

        sb.append("\n");

        teamMates.sort(Comparator.comparing(i -> -1 * i.solvedCnt));
        teamMates.forEach(i -> sb.append(i.familyName.charAt(0)));

        System.out.println(sb);
        br.close();
    }

    private static class TeamMate {
        int birth;
        String familyName;
        int solvedCnt;

        public TeamMate(int birth, String familyName, int solvedCnt) {
            this.birth = birth;
            this.familyName = familyName;
            this.solvedCnt = solvedCnt;
        }
    }
}
