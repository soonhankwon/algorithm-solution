import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        ArrayList<Long> nums = new ArrayList<>();

        LongStream.range(0, n).forEach(i -> {
            try {
                nums.add(Long.valueOf(br.readLine()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        nums.sort(Comparator.comparingLong(o -> o));
        nums.forEach(System.out::println);
    }
}