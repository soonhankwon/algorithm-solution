#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> strlist) {
    int size = strlist.size();
    vector<int> answer(size);
    for(int i = 0; i < size; i++) {
        answer[i] = strlist[i].length();
    }
    return answer;
}