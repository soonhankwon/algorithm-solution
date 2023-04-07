import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalScore = 0;
        double totalCredit = 0;

        for (int i = 0; i < 20; i++) {
            String[] s = scanner.nextLine().split(" ");
            if (s.length <= 2) {
                break;
            }
            if (s[2].equals("P")) {
                continue;
            }
            totalCredit += Double.parseDouble(s[1]);
            totalScore += Double.parseDouble(s[1]) * calculateScore(s[2]);
        }

        System.out.println(totalScore / totalCredit);
    }

    private static double calculateScore(String credit) {
        if (String.valueOf(credit.charAt(0)).equals(Credit.A.toString()) &&
                String.valueOf(credit.charAt(1)).equals("+")) {
            return Credit.A.creditScore + Credit.PLUS.creditScore;
        }
        if (String.valueOf(credit.charAt(0)).equals(Credit.A.toString()) &&
                String.valueOf(credit.charAt(1)).equals("0")) {
            return Credit.A.creditScore;
        }
        if (String.valueOf(credit.charAt(0)).equals(Credit.B.toString()) &&
                String.valueOf(credit.charAt(1)).equals("+")) {
            return Credit.B.creditScore + Credit.PLUS.creditScore;
        }
        if (String.valueOf(credit.charAt(0)).equals(Credit.B.toString()) &&
                String.valueOf(credit.charAt(1)).equals("0")) {
            return Credit.B.creditScore;
        }
        if (String.valueOf(credit.charAt(0)).equals(Credit.C.toString()) &&
                String.valueOf(credit.charAt(1)).equals("+")) {
            return Credit.C.creditScore + Credit.PLUS.creditScore;
        }
        if (String.valueOf(credit.charAt(0)).equals(Credit.C.toString()) &&
                String.valueOf(credit.charAt(1)).equals("0")) {
            return Credit.C.creditScore;
        }
        if (String.valueOf(credit.charAt(0)).equals(Credit.D.toString()) &&
                String.valueOf(credit.charAt(1)).equals("+")) {
            return Credit.D.creditScore + Credit.PLUS.creditScore;
        }
        if (String.valueOf(credit.charAt(0)).equals(Credit.D.toString()) &&
                String.valueOf(credit.charAt(1)).equals("0")) {
            return Credit.D.creditScore;
        } else {
            return Credit.F.creditScore;
        }
    }
}

enum Credit {
    A(4.0), B(3.0), C(2.0), D(1.0), F(0.0),
    PLUS(0.5);

    final double creditScore;

    Credit(double creditScore) {
        this.creditScore = creditScore;
    }
}