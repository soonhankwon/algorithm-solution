import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cacheQueue = new LinkedList<>();
        int answer = 0;
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        for (String city : cities) {
            String cityLowerCased = city.toLowerCase();
            if (cacheQueue.size() < cacheSize) {
                if(isCityExistCache(cacheQueue, cityLowerCased)) {
                    cacheQueue.remove(cityLowerCased);
                    cacheQueue.add(cityLowerCased);
                    answer++;
                }
                else {
                    cacheQueue.add(cityLowerCased);
                    answer = cacheMiss(answer);
                }
            }
            else {
                if(isCityExistCache(cacheQueue, cityLowerCased)) {
                    cacheQueue.remove(cityLowerCased);
                    cacheQueue.add(cityLowerCased);
                    answer++;
                }
                else {
                    cacheData(cacheQueue, cityLowerCased);
                    answer = cacheMiss(answer);
                }
            }
        }
        return answer;
    }
    
    private static boolean isCityExistCache(Queue<String> cacheQueue, String city) {
        return cacheQueue.contains(city);
    }

    private static void cacheData(Queue<String> cacheQueue, String city) {
        cacheQueue.poll();
        cacheQueue.add(city);
    }
    
    private static int cacheMiss(int answer) {
        answer += 5;
        return answer;
    }
}