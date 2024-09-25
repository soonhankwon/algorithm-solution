#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int index = 1;
    int answer = 0;
    while(index <= n / 2) {
        if(n % index == 0) {
            answer += index;
        }
        index++;
    }
    return answer + n;
}