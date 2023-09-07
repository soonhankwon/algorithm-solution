class Solution {
    public boolean solution(String s) {
        int sLength = s.length();
        if(sLength != 4 && sLength != 6) {
            return false;
        }
        
        if(s.matches(".*[a-zA-Z].*")) {
            return false;
        } 
        return true;
    }
}