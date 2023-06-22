#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;
map<string,int> m;
vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer;
    for(int i=0;i<name.size();i++){
        m[name[i]]=yearning[i];
    }
    for(auto a:photo){
        int sum=0;
        for(auto b:a){
            sum+=m[b];
        }
        answer.push_back(sum);
    }
    return answer;
}