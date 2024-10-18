#include <string>
#include <vector>

using namespace std;

string solution(int num) {
    if(num == 0) return "Even";
    return num % 2 != 0 ? "Odd" : "Even";
}