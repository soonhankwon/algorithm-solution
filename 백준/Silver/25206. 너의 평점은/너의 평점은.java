import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //input cnt = 20
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double totalScore = 0;
        double totalCredit = 0;
        for (int i = 0; i < 20; i++) {
            String[] inputs = br.readLine().split(" ");
            String inputCredit = inputs[1];
            String inputGrade = inputs[2];
            // 학점은 인정되지만 스코어에 포함되지 않음(계산X)
            if (inputGrade.equals("P")) {
                continue;
            }
            CreditInfo creditInfo = new CreditInfo(inputCredit, inputGrade);
            double credit = Double.parseDouble(inputCredit);
            totalScore += creditInfo.convertScore();
            totalCredit += credit;
        }

        System.out.println(totalScore / totalCredit);
    }

    public static class CreditInfo {
        String credit;
        String grade;

        public CreditInfo(String credit, String grade) {
            this.credit = credit;
            this.grade = grade;
        }

        public double convertScore() {
            double myCredit = Double.parseDouble(credit);
            if (grade.equals("A+")) {
                return myCredit * 4.5;
            }
            if (grade.equals("A0")) {
                return myCredit * 4.0;
            }
            if (grade.equals("B+")) {
                return myCredit * 3.5;
            }
            if (grade.equals("B0")) {
                return myCredit * 3.0;
            }
            if (grade.equals("C+")) {
                return myCredit * 2.5;
            }
            if (grade.equals("C0")) {
                return myCredit * 2.0;
            }
            if (grade.equals("D+")) {
                return myCredit * 1.5;
            }
            if (grade.equals("D0")) {
                return myCredit;
            }
            return 0;
        }
    }
}
