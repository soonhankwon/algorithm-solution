import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int number = 2;
        for(int i = 0; i < n; i++) {
            if(n % number == 0) {
                n /= number;
                System.out.println(number);
            } else {
                number++;
            }
        }
        if(n > 1) {
            System.out.println(n);
        }
    }
}