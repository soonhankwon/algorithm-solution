#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int k) {
    vector<int> answer;
    for(int i = 1; i <= n; i++) {
        int mul = i * k;
        if(mul > n) break;
        answer.push_back(mul);
    }
    return answer;
}