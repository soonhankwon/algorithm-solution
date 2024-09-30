#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> sides) {
    sort(sides.begin(), sides.end());
    int size= sides.size();
    return sides[size - 1] < sides[size - 2] + sides[size - 3] ? 1 : 2;
}