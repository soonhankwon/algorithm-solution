#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int x0 = stoi(to_string(a) + to_string(b));
    int x1 = stoi(to_string(b) + to_string(a));
    return x0 > x1 ? x0 : x1;
}