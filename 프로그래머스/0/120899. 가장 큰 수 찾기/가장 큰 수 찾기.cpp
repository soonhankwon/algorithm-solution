#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> array) {
    vector<int> answer = {0, 0};
    int maxValue = -1;
    int size = array.size();
    for(int i = 0; i < size; i++) {
        maxValue = max(maxValue, array[i]);
    }
    answer[0] = maxValue;
    for(int i = 0; i < size; i++) {
        if(array[i] == maxValue) {
            answer[1] = i;
        }
    }
    return answer;
}