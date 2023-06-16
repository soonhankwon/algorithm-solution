import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    private static int answer;
    
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cacheQueue = new LinkedList<>();
        answer = 0;
        if (isNotUsedCache(cacheSize)) {
            return cities.length * 5;
        }

        for (String c : cities) {
            String city = c.toLowerCase();
            if (isCacheSpaceUnderCacheSize(cacheSize, cacheQueue)) {
                getExecutionTime(cacheSize, cacheQueue, city);
            }
            else {
                getExecutionTime(cacheSize, cacheQueue, city);
            }
        }
        return answer;
    }
    
    private static boolean isNotUsedCache(int cacheSize) {
        return cacheSize == 0;
    }

    private static boolean isCacheSpaceUnderCacheSize(int cacheSize, Queue<String> cacheQueue) {
        return cacheQueue.size() < cacheSize;
    }

    private static void getExecutionTime(int cacheSize, Queue<String> cacheQueue, String city) {
        if (isCityExistCache(cacheQueue, city)) {
            cachingCaseByHit(cacheQueue, city);
            answer++;
        } else {
            cachingCaseByMissAndCacheSpace(cacheQueue, city, isCacheSpaceUnderCacheSize(cacheSize, cacheQueue));
            answer += 5;
        }
    }

    private static boolean isCityExistCache(Queue<String> cacheQueue, String city) {
        return cacheQueue.contains(city);
    }

    private static void cachingCaseByHit(Queue<String> cacheQueue, String cityLowerCased) {
        cacheQueue.remove(cityLowerCased);
        cacheQueue.add(cityLowerCased);
    }

    private static void cachingCaseByMissAndCacheSpace(Queue<String> cacheQueue, String city, boolean isCacheSpaceUnderCacheSize) {
        if (isCacheSpaceUnderCacheSize) {
            cacheQueue.add(city);
        }
        else {
            cacheQueue.poll();
            cacheQueue.add(city);
        }
    }
}