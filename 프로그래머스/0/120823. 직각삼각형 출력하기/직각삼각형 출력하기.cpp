#include <iostream>
#include <string>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    string star = "";
    for(int i = 0; i < n; i++) {
        star += "*";
        cout << star << endl;
    }
    return 0;
}