import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int month = data[0];
        int day = data[1];
        DayOfWeek dayOfWeek = LocalDate.of(2007, month, day)
                .getDayOfWeek();
        System.out.println(dayOfWeek.toString().substring(0, 3));
        br.close();
    }
}