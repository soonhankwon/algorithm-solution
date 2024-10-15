#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int sum = 0;
    int multipleSum = 1;
    for(int n : num_list) {
        sum += n;
        multipleSum *= n;
    }
    return multipleSum > sum * sum ? 0 : 1;
}