#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <sstream>
#include <stack>

using namespace std;

bool cmp(vector<string> a, vector<string> b){
    return a[1]<b[1];
}

vector<string> split(string str, char Delimiter) {
    istringstream iss(str);             // istringstream에 str을 담는다.
    string buffer;                      // 구분자를 기준으로 절삭된 문자열이 담겨지는 버퍼
 
    vector<string> result;
 
    // istringstream은 istream을 상속받으므로 getline을 사용할 수 있다.
    while (getline(iss, buffer, Delimiter)) {
        result.push_back(buffer);               // 절삭된 문자열을 vector에 저장
    }
 
    return result;
}

vector<string> solution(vector<vector<string>> plans) {
    vector<string> answer;
    sort(plans.begin(),plans.end(),cmp);
    
    stack <pair<string,int>> stop;
    
    for(int i=0;i<plans.size()-1;i++){
        int h1,m1,h2,m2,diff;
        vector<string> a,b;
        a=split(plans[i][1],':');
        b=split(plans[i+1][1],':');
        h1=stoi(a[0]);
        m1=stoi(a[1]);
        h2=stoi(b[0]);
        m2=stoi(b[1]);
        diff=(h2-h1)*60+m2-m1;

        int remain_time = diff - stoi(plans[i][2]);
        if(remain_time >= 0){
            answer.push_back(plans[i][0]);
            while(remain_time>=0){
                if(stop.empty()!=1){
                    string tmp_str=stop.top().first;
                    int time=stop.top().second;
                    stop.pop();

                    if(remain_time - time >=0){
                        answer.push_back(tmp_str);
                        
                    }
                    else{
                        stop.push(make_pair(tmp_str,time-remain_time));
                    }
                    remain_time-=time;
                }
                else{
                    break;
                }
            }
        }
        else{
            stop.push(make_pair(plans[i][0],-remain_time));
        }
    }
    answer.push_back(plans[plans.size()-1][0]);
    while(!stop.empty()){
        answer.push_back(stop.top().first);
        stop.pop();
    }
    
    return answer;
}