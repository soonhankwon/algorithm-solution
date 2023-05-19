import java.util.Scanner;
import java.util.stream.IntStream;

public class P10809_알파벳 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        IntStream.range(97, 123).forEach(i -> System.out.print(str.indexOf(i) + " "));
    }
}
