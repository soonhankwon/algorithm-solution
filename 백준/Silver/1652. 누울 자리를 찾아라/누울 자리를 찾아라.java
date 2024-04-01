import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        //한번 누우면 쭉 펴서 잔기때문에 벽이나 짐에 몸이 단다 -> 한줄에 자리는 하나임
        //결국 가로 세로를 탐색하면서 2개이상 비어있으면 카운트
        //가운데 X가 있으면 2개로 카운트!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 행렬배열
        String[] rows = new String[n];
        // 열배열
        String[] columns = new String[n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            rows[i] = row;
            // 열을 만들어줌
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    columns[j] = String.valueOf(row.charAt(j));
                    continue;
                }
                columns[j] += row.charAt(j);
            }
        }

        int tmp;
        int wCnt = 0;
        for (int i = 0; i < n; i++) {
            tmp = 0;
            for (int j = 0; j < n; j++) {
                // .인경우
                if (rows[i].charAt(j) == '.') {
                    tmp++;
                    if (j == n - 1 && tmp >= 2) {
                        wCnt++;
                        break;
                    }
                }
                // X 인 경우
                else {
                    if (j == n - 1 && tmp >= 2) {
                        wCnt++;
                        break;
                    }
                    if (tmp >= 2) {
                        wCnt++;
                    }
                    tmp = 0;
                }
            }
        }

        int hCnt = 0;
        for (int i = 0; i < n; i++) {
            tmp = 0;
            for (int j = 0; j < n; j++) {
                // .인경우
                if (columns[i].charAt(j) == '.') {
                    tmp++;
                    if (j == n - 1 && tmp >= 2) {
                        hCnt++;
                        break;
                    }
                }
                // X 인 경우
                else {
                    if (j == n - 1 && tmp >= 2) {
                        hCnt++;
                        break;
                    }
                    if (tmp >= 2) {
                        hCnt++;
                    }
                    tmp = 0;
                }
            }
        }
        System.out.println(wCnt + " " + hCnt);
        br.close();
    }
}
