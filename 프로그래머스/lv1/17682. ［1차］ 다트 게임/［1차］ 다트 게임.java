import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String dartResult) {
        List<String> scores = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "0"));
        List<String> bonuses = new ArrayList<>(List.of("S", "D", "T"));
        List<String> options = new ArrayList<>(List.of("*", "#"));

        int totalScore = 0;
        int tempNowScore = 0;
        int tempBeforeScore = 0;
        String tempBonus = null;
        for (int i = 0; i < dartResult.length(); i++) {
            String nowInput = String.valueOf(dartResult.charAt(i));
            if(i < dartResult.length() - 1 && scores.contains(nowInput) && scores.contains(String.valueOf(dartResult.charAt(i + 1)))) {
                tempBeforeScore = tempNowScore;
                totalScore += tempNowScore;
                tempNowScore = 10;
                i++;
                continue;
            }
            
            if (tempBonus != null && scores.contains(nowInput) && i > 0 && tempBonus.equals("*")) {
                tempBeforeScore = tempNowScore - tempBeforeScore;
                totalScore += tempNowScore;
                tempNowScore = Integer.parseInt(nowInput);
                continue;
            }
            if (scores.contains(nowInput) && i > 0) {
                tempBeforeScore = tempNowScore;
                totalScore += tempNowScore;
                tempNowScore = Integer.parseInt(nowInput);
                continue;
            } else if (scores.contains(nowInput) && i == 0) {
                tempNowScore = Integer.parseInt(nowInput);
                continue;
            }
            
            if (bonuses.contains(nowInput)) {
                if (nowInput.equals("D")) {
                    tempNowScore = (int) Math.pow(tempNowScore, 2);
                    continue;
                }
                if (nowInput.equals("T")) {
                    tempNowScore = (int) Math.pow(tempNowScore, 3);
                    continue;
                } else {
                    continue;
                }
            }
            
            if (options.contains(nowInput)) {
                if (nowInput.equals("*")) {
                    if(tempBeforeScore == 0) {
                        tempNowScore = tempNowScore * 2;
                    } else {
                        int bonusScore = (tempBeforeScore * 2) + (tempNowScore * 2);
                        totalScore -= tempBeforeScore;
                        tempNowScore = bonusScore;
                        tempBeforeScore *= 2;
                    }
                    tempBonus = "*";
                } else {
                    tempNowScore = tempNowScore * -1;
                    tempBonus = "#";
                }
            }
        }

        return totalScore + tempNowScore;
    }
}