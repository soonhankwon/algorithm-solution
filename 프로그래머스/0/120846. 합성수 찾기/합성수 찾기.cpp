#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    for(int i = 4; i <= n; i++) {
        int cnt = 1;
        for(int j = 2; j <= i; j++) {
            if(i % j == 0) {
                cnt++;
            }
            if(cnt >= 3) {
                answer++;
                break;
            }
        }
    }
    return answer;
}