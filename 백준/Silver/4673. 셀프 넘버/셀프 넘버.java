public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int index = 10000;
        boolean[] numbers = new boolean[index + 1];
        for (int i = 1; i <= index; i++) {
            int n = executeSelfNumber(i);
            if (n <= index) {
                numbers[n] = true;
            }
            if (!numbers[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int executeSelfNumber(int num) {
        int sum = num;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
