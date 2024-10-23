#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers, int num1, int num2) {
    int size = numbers.size();
    vector<int> answer;
    for(int i = 0; i < size; i++) {
        if(i < num1 || i > num2) {
            continue;
        }
        answer.push_back(numbers[i]);
    }
    return answer;
}