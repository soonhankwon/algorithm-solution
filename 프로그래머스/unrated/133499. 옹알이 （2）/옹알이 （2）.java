class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        // 완벽히 일치해야 카운트
        for (String expression : babbling) {
            if (isExpressionRepeated(expression)) continue;
            expression = convertExpressionWithPatterns(expression);
            
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
        for(String pattern : patterns) {
            expression = expression.replace(pattern, " ");
        }
        return expression.replace(" ", "");
    }
    
    private static boolean isBabyCanBabbling(String expression) {
        return expression.length() == 0;
    }
}