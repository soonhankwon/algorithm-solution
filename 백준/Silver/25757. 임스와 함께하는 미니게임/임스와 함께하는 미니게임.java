import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String game = scanner.next();
        scanner.nextLine();

        Set<String> set = IntStream.range(0, N)
                .mapToObj(i -> scanner.nextLine())
                .collect(Collectors.toSet());

        int count = Math.floorDiv(set.size(), Game.valueOf(game).MaxNumberOfPeople - 1);
        System.out.println(count);
    }
}

enum Game {
    Y(2), F(3), O(4);
    final int MaxNumberOfPeople;

    Game(int MaxNumberOfPeople) {
        this.MaxNumberOfPeople = MaxNumberOfPeople;
    }
}