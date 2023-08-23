import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(String.valueOf(n).split(""))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .forEach(sb::append);
        return Long.parseLong(sb.toString());
    }
}