#include <string>
#include <vector>

using namespace std;

int solution(vector<int> arr1, vector<int> arr2) {
    int size1 = arr1.size();
    int size2 = arr2.size();
    if(size1 != size2) {
        return size1 > size2 ? 1 : -1;
    }
    
    int sum = 0;
    for(int i = 0; i < size1; i++) {
        sum += arr1[i];
        sum -= arr2[i];
    }
    if(sum > 0) {
        return 1;
    } else if(sum < 0){
        return -1;
    }
    return 0;
}