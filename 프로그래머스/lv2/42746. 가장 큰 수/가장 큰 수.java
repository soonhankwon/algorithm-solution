import java.util.Arrays;

class Solution {
    
    public String solution(int[] numbers) {
        String[] numbersArr = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .toArray(String[]::new);

        if(numbersArr[0].equals("0")) {
            return "0";
        }
        return String.join("", numbersArr);
    }
}
