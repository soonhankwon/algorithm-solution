import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<LocalTime> timeStandards = Arrays.stream(br.readLine().split(" "))
                .map(input -> LocalTime.parse(input, TIME_FORMATTER))
                .collect(Collectors.toList());
        LocalTime start = timeStandards.get(0);
        LocalTime end = timeStandards.get(1);
        LocalTime limit = timeStandards.get(2);
        Set<String> participants = new HashSet<>();
        Set<String> result = new HashSet<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] input = line.split(" ");
            LocalTime time = LocalTime.parse(input[0], TIME_FORMATTER);
            String id = input[1];
            if (time.isBefore(start) || time.equals(start)) {
                participants.add(id);
            }
            if ((time.isAfter(end) || time.equals(end)) && (time.isBefore(limit) || time.equals(limit))) {
                if (participants.contains(id)) {
                    result.add(id);
                }
            }
        }
        System.out.println(result.size());
        br.close();
    }
}
