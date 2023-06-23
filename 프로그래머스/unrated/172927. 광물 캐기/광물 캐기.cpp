#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(vector<int> picks, vector<string> minerals) {
    int answer = 0;
    int cnt=0;
    for(auto a:picks){
        cnt+=a;
    }
    vector<pair<int,int>> priority;
    int sum=0,t=0;
    for(auto a=minerals.begin();a!=minerals.end();a++){
        if(*a=="diamond") sum+=25;
        else if(*a=="iron") sum+=5;
        else sum+=1;
        t++;
        
        if(t%5==0) {
            priority.push_back(make_pair(-sum,t-5));
            sum=0;
        }
        if(t>cnt*5) {
            sum=0;
            break;
        }
    }
    if(sum!=0) priority.push_back(make_pair(-sum,t-t%5));
    sort(priority.begin(),priority.end());
    
    int idx=0;
    for(int i=0;i<priority.size();i++){
        while(picks[idx]==0) {
            idx++;
        }
        picks[idx]--;
        if(idx==0){
            for(int j=priority[i].second;j<priority[i].second+5;j++){
                if(j>=minerals.size()) break;
                answer+=1;
            }
        }
        else if(idx==1){
            for(int j=priority[i].second;j<priority[i].second+5;j++){
                if(j>=minerals.size()) break;
                if(minerals[j]=="diamond") answer+=5;
                else answer+=1;
            }
        }
        else{
            for(int j=priority[i].second;j<priority[i].second+5;j++){
                if(j>=minerals.size()) break;
                if(minerals[j]=="diamond") answer+=25;
                else if(minerals[j]=="iron") answer +=5;
                else answer+=1;
            }
        }
    }
    return answer;
}