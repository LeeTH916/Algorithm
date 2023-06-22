#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer;
    int a=0,b=0;
    int ans1,ans2;
    int sum=0;
    int min = 10000000;
    while(b<=sequence.size() && a<=b){
        if(sum==k){
            if(min>b-a){
                min=b-a;
                ans1=a;
                ans2=b-1;
            }
            if(b>=sequence.size()) break;
            sum+=sequence[b++];
        }
        else if(sum<k){
            sum+=sequence[b++];
        }
        else if(sum>k){
            sum-=sequence[a++];
        }
    }
    answer.push_back(ans1);
    answer.push_back(ans2);
    return answer;
}