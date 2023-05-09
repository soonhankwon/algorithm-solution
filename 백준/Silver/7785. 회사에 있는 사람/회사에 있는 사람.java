import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<String, String> map = new HashMap<>();
        IntStream.range(0, n).forEach(i -> map.put(scanner.next(), scanner.next()));

        new ArrayList<>(map.keySet()).stream()
                .filter(i -> map.get(i).equals("enter"))
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}