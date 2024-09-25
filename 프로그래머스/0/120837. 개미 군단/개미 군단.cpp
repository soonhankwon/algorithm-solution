#include <string>
#include <vector>

using namespace std;

int solution(int hp) {
    int answer = 0;
    if(hp %  5 >= 0) {
        answer += hp / 5;
        hp = hp % 5;
    }
    if(hp % 3 >= 0) {
        answer += hp / 3;
        hp = hp % 3;
    }
    return hp == 0 ? answer : answer + hp;
}