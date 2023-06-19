#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool cmp(vector<int> &t1, vector<int> &t2){
    return t1[1]<t2[1];
}

int solution(vector<vector<int>> targets) {
    int answer = 0;
    int last=0;
    sort(targets.begin(),targets.end(),cmp);
    
    for(auto a:targets){
        if(a[0]<last && a[1]>=last){
            continue;
        }
        else{
            last=a[1];
            answer++;
        }
    }
    return answer;
}