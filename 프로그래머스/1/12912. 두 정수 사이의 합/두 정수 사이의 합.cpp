#include <string>
#include <vector>

using namespace std;

long long solution(int a, int b) {
    long long sum = 0;
    if(a == b) {
        return a;
    }
    if(a > b) {
        for(int i = b; i <= a; i++) {
            sum += i;
        }
    } else {
        for(int i = a; i <= b; i++) {
            sum += i;
        }
    }
    return sum;
}