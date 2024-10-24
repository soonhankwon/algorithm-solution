#include <string>
#include <vector>

using namespace std;

int solution(vector<int> box, int n) {
    int x, y, z;
    for(int i = 0; i < 3; i++) {
        if(i == 0) {
            x = box[i] / n;
        } else if(i == 1) {
            y = box[i] / n;
        } else {
            z = box[i] / n;
        }
    }
    int answer = x * y * z;
    return answer;
}