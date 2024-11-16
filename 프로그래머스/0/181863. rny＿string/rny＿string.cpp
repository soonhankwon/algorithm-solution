#include <string>
#include <vector>

using namespace std;

string solution(string rny_string) {
    string answer = "";
    for(int i = 0; i < rny_string.size(); i++) {
        char c = rny_string[i];
        c == 'm' ? answer += "rn" : answer += c;
    }
    return answer;
}