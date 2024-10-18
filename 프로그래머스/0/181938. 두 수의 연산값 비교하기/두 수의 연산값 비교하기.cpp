#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int x1 = stoi(to_string(a) + to_string(b));
    int x2 = 2 * a * b;
    return x1 > x2 ? x1 : x2;
}