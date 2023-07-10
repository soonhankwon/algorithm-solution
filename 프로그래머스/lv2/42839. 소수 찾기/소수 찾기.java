import java.util.stream.IntStream;
import java.util.ArrayList;

class Solution {
    
    private static String[] split;
    private static int count;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer> usedNumber = new ArrayList<>();
    
    public int solution(String numbers) {
        count = 0;
        split = numbers.split("");
        visited = new boolean[split.length];

        IntStream.rangeClosed(1, numbers.length())
                .forEach(i -> perm(0, i));
        return count;
    }
    
    private static void perm(int depth, int r) {
        if (depth == r) {
            int tempStr = Integer.parseInt(sb.toString());
            if(usedNumber.contains(tempStr)) {
                return;
            } else {
                usedNumber.add(tempStr);
            }
            System.out.println(sb.toString());
            if (isPrimeNumber(tempStr)) {
                count++;
            }
            return;
        }
        for (int i = 0; i < split.length; i++) {
            if (sb.toString().isEmpty() && split[i].equals("0"))
                continue;
            if (!visited[i]) {
                visited[i] = true;
                sb.append(split[i]);
                perm(depth + 1, r);
                visited[i] = false;
                sb.setLength(sb.length() - 1);
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        } else if (number == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}