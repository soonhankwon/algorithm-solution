import java.util.Arrays;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String expression : babbling) {
            if (isExpressionRepeated(expression)) continue;
            expression  = convertExpressionWithPatterns(expression);
            if (isBabyCanBabbling(expression)) {
                answer++;
            }
        }
        return answer;
    }
    
    private static boolean isExpressionRepeated(String str) {
        return str.contains("ayaaya") || str.contains("yeye") || str.contains("woowoo") || str.contains("mama");
    }

    private static String convertExpressionWithPatterns(String expression) {
        String[] patterns = {"aya", "ye", "woo", "ma"};
        return Arrays.stream(patterns)
                .reduce(expression, (res, pattern) -> res.replace(pattern, " "))
                .replaceAll(" ", "");
    }
    
    private static boolean isBabyCanBabbling(String expression) {
        return expression.length() == 0;
    }
}
