import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int upCount = 0;
    static int downCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initialBudget = Integer.parseInt(br.readLine());
        int[] stockPrices = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int aBudget = initialBudget;
        int aStock = 0;
        int bBudget = initialBudget;
        int bStock = 0;
        int yesterdayStockPrice = stockPrices[0];
        for (int i = 0; i < stockPrices.length; i++) {
            // 주식 현재가
            int nowStockPrice = stockPrices[i];
            // 연속상승 및 하락 카운팅
            if (i > 0) {
                if (yesterdayStockPrice < nowStockPrice) {
                    upCount++;
                    downCount = 0;
                } else if (yesterdayStockPrice > nowStockPrice) {
                    downCount++;
                    upCount = 0;
                } else {
                    upCount = 0;
                    downCount = 0;
                }
            }
            // 1.준현 BNP: Greedy
            if (nowStockPrice <= aBudget) {
                aStock += aBudget / nowStockPrice;
                aBudget %= nowStockPrice;
            }
            // 2.성민 TIMING: 3.3.3 법칙
            // 전량매수
            if (downCount == 3) {
                int sharesToBuy = bBudget / nowStockPrice;
                bStock += sharesToBuy;
                bBudget -= sharesToBuy * nowStockPrice;
            }
            // 전량매도
            else if (upCount == 3) {
                bBudget += bStock * nowStockPrice;
                bStock = 0;
            }
            yesterdayStockPrice = nowStockPrice;
        }
        aBudget += aStock * yesterdayStockPrice;
        bBudget += bStock * yesterdayStockPrice;
        if (aBudget > bBudget) {
            System.out.println("BNP");
        } else if (aBudget < bBudget) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
        br.close();
    }
}