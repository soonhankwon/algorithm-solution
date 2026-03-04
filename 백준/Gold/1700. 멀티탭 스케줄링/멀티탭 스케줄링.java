import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * 플러그를 빼는 최소 횟수
         * Input:
         * 2 7
         * 2 3 2 3 1 2 7
         * Output:
         * 2
         * 멀티탭의 구멍 수 n, 전기용품 총 사용횟수 k
         * 사용 전기용품 순서
         * 해결법: Belady's Algorithm 앞으로 가장 "나중에" 사용될 기기를 뽑음
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0];
        int k = inputs[1];

        int[] uses = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int plugOutCount = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < k; i++) {
            int appliance = uses[i];
            if(set.contains(appliance)) {
                continue;
            }
            if(set.size() < n) {
                set.add(appliance);
            } else {
                int itemToPlugOut = -1;
                int maxNextUseIndex = -1; // 가장 나중에 쓰이는 시점

                // 현재 꽂혀있는 기기 검사
                for (Integer plugIn : set) {
                    int nextUseIndex = Integer.MAX_VALUE;

                    // 현재 시점 이후로 언제쓰이는지 확인
                    for(int j = i + 1; j < k; j++) {
                        if(uses[j] == plugIn) {
                            nextUseIndex = j;
                            break;
                        }
                    }

                    // 앞으로 아예 사용되지 않는 기기를 찾았다면 1순위로 뽑음
                    if(nextUseIndex == Integer.MAX_VALUE) {
                        itemToPlugOut = plugIn;
                        break;
                    }

                    // 모두 앞으로 사용된다면, 그중에서 가장 나중에 사용되는 기기를 찾음
                    if(nextUseIndex > maxNextUseIndex) {
                        maxNextUseIndex = nextUseIndex;
                        itemToPlugOut = plugIn;
                    }
                }
                set.remove(itemToPlugOut);
                set.add(appliance);
                plugOutCount++;
            }
        }
        System.out.println(plugOutCount);
        br.close();
    }
}
