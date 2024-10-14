#include <string>
#include <vector>

using namespace std;
string findAnswer(char input);

string solution(string rsp) {
    string answer;
    for(int i = 0; i < rsp.length(); i++) {
        answer += findAnswer(rsp[i]);
    }
    return answer;
}

string findAnswer(char input) {
    if(input == '2') {
        return "0";
    }
    else if(input == '0') {
        return "5";
    } 
    else {
        return "2";
    }
}