import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 1 ~ n 까지의 합 n(n-1)/2
        long count = (long) n * (n - 1) / 2;
        System.out.println(count + "\n" + 2);
    }
}