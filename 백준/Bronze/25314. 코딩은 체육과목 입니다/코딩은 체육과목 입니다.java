import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt() / 4;
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, n).forEach(i -> sb.append("long "));
        System.out.println(sb + "int");
    }
}