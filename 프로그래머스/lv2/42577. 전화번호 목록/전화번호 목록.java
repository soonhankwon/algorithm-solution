import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        set.addAll(Arrays.asList(phone_book));

        for (String phoneNumber : phone_book) {
            for(int i = 0; i < phoneNumber.length(); i++) {
                if(set.contains(phoneNumber.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}