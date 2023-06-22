#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

map <string,int> m;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer;
    answer.assign(players.begin(),players.end());
    for(int i=0;i<players.size();i++){
        m[players[i]]=i;
    }

    for(auto a:callings){
        int tmp1=m[answer[m[a]-1]];
        int tmp2=m[a];
        answer[m[a]].swap(answer[m[a]-1]);
        m[answer[tmp1]]=tmp1;
        m[answer[tmp2]]=tmp2;
    }
    return answer;
}