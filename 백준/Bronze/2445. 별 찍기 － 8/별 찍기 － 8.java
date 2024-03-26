import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int spaceCnt1 = (n * 2) - 2;
        for (int i = 1; i <= n; i++) {
            sb.append("*".repeat(i));
            sb.append(" ".repeat(spaceCnt1));
            sb.append("*".repeat(i));
            sb.append("\n");
            if (spaceCnt1 > 0) {
                spaceCnt1 -= 2;
            }
        }
        spaceCnt1 += 2;
        for (int i = n - 1; i > 0; i--) {
            sb.append("*".repeat(i));
            sb.append(" ".repeat(spaceCnt1));
            sb.append("*".repeat(i));
            sb.append("\n");
            spaceCnt1 += 2;
        }
        System.out.println(sb);
        sc.close();
    }
}
