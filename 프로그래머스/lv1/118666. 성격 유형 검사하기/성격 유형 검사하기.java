import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<PersonalityType, Integer> map = new HashMap<>();
        initPersonalityTypeMap(map);
        calculateTypeScore(survey, choices, map);
        return getPersonalityTypeResult(map);
    }
    
    private static void initPersonalityTypeMap(Map<PersonalityType, Integer> map) {
        for (PersonalityType type : PersonalityType.values()) {
            map.put(type, 0);
        }
    }

    private static void calculateTypeScore(String[] survey, int[] choices, Map<PersonalityType, Integer> map) {
        for (int i = 0; i < survey.length; i++) {
            String str = survey[i];
            if (isSurveyMatchPersonalityType(str)) {
                PersonalityType key = PersonalityType.valueOf(survey[i]);
                map.put(key, map.get(key) - (choices[i] - 4));
            } else {
                String str1 = String.valueOf(survey[i].charAt(1));
                String str2 = String.valueOf(survey[i].charAt(0));
                PersonalityType key = PersonalityType.valueOf(str1 + str2);
                map.put(key, map.get(key) + (choices[i] - 4));
            }
        }
    }

    private static boolean isSurveyMatchPersonalityType(String str) {
        return Arrays.stream(PersonalityType.values())
                .anyMatch(v -> v.name().equals(str));
    }

    private static String getPersonalityTypeResult(Map<PersonalityType, Integer> map) {
        StringBuilder sb = new StringBuilder();
        PersonalityType[] types = PersonalityType.values();
        //RT , CF, JM, AN
        Arrays.stream(types).forEach(type -> {
            if (isTypeValuePositive(map, type)) {
                sb.append(type.name().charAt(0));
            } else if (map.get(type) < 0) {
                sb.append(type.name().charAt(1));
            } else {
                if (type.name().charAt(0) > type.name().charAt(1))
                    sb.append(type.name().charAt(1));
                else
                    sb.append(type.name().charAt(0));
            }
        });
        return sb.toString();
    }

    private static boolean isTypeValuePositive(Map<PersonalityType, Integer> map, PersonalityType type) {
        return map.get(type) > 0;
    }

    public enum PersonalityType {
        RT, CF, JM, AN
    }
}