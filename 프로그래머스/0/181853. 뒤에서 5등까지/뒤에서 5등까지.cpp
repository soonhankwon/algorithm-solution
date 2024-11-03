#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> num_list) {
    sort(num_list.begin(), num_list.end());
    if(num_list.size() > 5) {
        return vector<int>(num_list.begin(), num_list.begin() + 5);
    } else {
        return num_list;   
    }
}