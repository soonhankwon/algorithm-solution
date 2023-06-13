import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> map = new HashMap<>();
        getTypeMap(map);
        calculateScore(survey, choices, map);
        return getPersonalityTypeResult(map);
    }
    
    private static String getPersonalityTypeResult(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        PersonalityType[] values = PersonalityType.values();
        //RT , CF, JM, AN
        for (PersonalityType value : values) {
            if (map.get(value.name()) > 0) {
                sb.append(value.name().charAt(0));
            } else if (map.get(value.name()) < 0) {
                sb.append(value.name().charAt(1));
            } else {
                if (value.name().charAt(0) > value.name().charAt(1))
                    sb.append(value.name().charAt(1));
                else
                    sb.append(value.name().charAt(0));
            }
        }
        return sb.toString();
    }

    private static void getTypeMap(Map<String, Integer> map) {
        for (PersonalityType type : PersonalityType.values()) {
            map.put(type.name(), 0);
        }
    }

    private static void calculateScore(String[] survey, int[] choices, Map<String, Integer> map) {
        for (int i = 0; i < survey.length; i++) {
                String str = survey[i];
                if (isSurveyMatchPersonalityType(str)) {
                    String key = String.valueOf(survey[i]);
                    map.put(key, map.get(key) - (choices[i] - 4));
                } else {
                    String s1 = String.valueOf(survey[i].charAt(1));
                    String s2 = String.valueOf(survey[i].charAt(0));
                    String key = s1 + s2;
                    map.put(key, map.get(key) + (choices[i] - 4));
            }
        }
    }

    private static boolean isSurveyMatchPersonalityType(String str) {
        return Arrays.stream(PersonalityType.values())
                .anyMatch(v -> v.name().equals(str));
    }

    public enum PersonalityType {
        RT, CF, JM, AN
    }
}