#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    string str = to_string(x);
    int sum = int{0};
    for(int i = 0; i < str.length(); i++) {
        sum += str.at(i) - '0';
    }
    return x % sum == 0;
}