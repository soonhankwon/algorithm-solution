import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] row;
    static int n, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            n = Integer.parseInt(br.readLine());
            // 16 + 16 = 32(2명이 겹치는 경우), 33명부터 3명이 겹침 -> 0
            row = br.readLine().split(" ");
            if (n > 32) {
                sb.append(0).append("\n");
                continue;
            }

            int min = getPsychologicalDistance();
            sb.append(min).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int getPsychologicalDistance() {
        min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                for (int l = k + 1; l < n; l++) {
                    int cnt = 0;
                    for (int m = 0; m < 4; m++) {
                        cnt += row[j].charAt(m) != row[k].charAt(m) ? 1 : 0;
                        cnt += row[j].charAt(m) != row[l].charAt(m) ? 1 : 0;
                        cnt += row[k].charAt(m) != row[l].charAt(m) ? 1 : 0;
                    }
                    min = Math.min(cnt, min);
                }
            }
        }
        return min;
    }
}
