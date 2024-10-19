#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{   
    string str = "";
    for(char ch : s) {
        str += tolower(ch);
    }
    int count = 0;
    for(int i = 0; i < s.length(); i++) {
        if(str.at(i) == 'p') {
            count++;
        } else if(str.at(i) == 'y') {
            count--;
        }
    }
    return count == 0;
}