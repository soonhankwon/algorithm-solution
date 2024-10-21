#include <string>
#include <vector>

using namespace std;

int gcd(int a, int b) {
    while(b != 0) {
        int temp = a % b;
        a = b;
        b = temp;
    }
    return a;
}

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    vector<int> answer;
    int numer = (numer1 * denom2) + (numer2 * denom1);
    int denom = denom1 * denom2;
    
    int gcdValue = gcd(numer, denom);
    numer /= gcdValue;
    denom /= gcdValue;
    answer.push_back(numer);
    answer.push_back(denom);
    return answer;
}