import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();

        // x월 전월까지 날짜총합을 계산
        int days = 0;
        for (int i = 1; i <= x - 1; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                days += 31;
                continue;
            }
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                days += 30;
                continue;
            }
            days += 28;
        }
        days += y;
        int day = days % 7;
        if (day == 1) {
            System.out.println("MON");
            return;
        }
        if (day == 2) {
            System.out.println("TUE");
            return;
        }
        if (day == 3) {
            System.out.println("WED");
            return;
        }
        if (day == 4) {
            System.out.println("THU");
            return;
        }
        if (day == 5) {
            System.out.println("FRI");
            return;
        }
        if (day == 6) {
            System.out.println("SAT");
            return;
        }
        System.out.println("SUN");
    }
}
