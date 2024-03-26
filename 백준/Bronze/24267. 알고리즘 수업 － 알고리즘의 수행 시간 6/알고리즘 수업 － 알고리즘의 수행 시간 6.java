import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 7개의 숫자중 3개를 뽑는 조합의 수 nCr
        // 7! / (7-3)! * 3!
        // 7 * 5 / 1 = 35
        long cnt = ((long) n * (n - 1) * (n - 2)) / 6;
        System.out.println(cnt + "\n" + 3);
    }
}
