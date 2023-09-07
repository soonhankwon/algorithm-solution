class Solution {
    
    static int answer;
    static int toMart;
    static int fromMart;
    
    public int solution(int a, int b, int n) {
        toMart = a;
        fromMart = b;
        return recursion(n, 0);
    }
    
    private int recursion(int coke, int result) {
        System.out.println(coke + " " + result);
        if(coke < toMart) {
            return result;
        }
        return recursion((coke % toMart) + (fromMart * (coke / toMart)), 
                         result + fromMart * (coke / toMart));
    }
}