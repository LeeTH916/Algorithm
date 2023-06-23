#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    int cur_x,cur_y;
    for(int y=0;y<park.size();y++){
        for(int x=0;x<park[y].size();x++){
            if(park[y][x]=='S'){
                cur_x=x;
                cur_y=y;
            }
        }
    }
    
    for(auto a:routes){
        string dir;
        int dist;
        dir=a.substr(0,1);
        dist=stoi(a.substr(2));
        
        int flag=0;
        if(dir=="N"){
            if(dist>cur_y) continue;
            int tmp_y;
            for(tmp_y=cur_y;tmp_y>cur_y-dist;tmp_y--){
                if(park[tmp_y-1][cur_x]=='X'){
                    flag=1;
                    break;
                }
            }
            if(flag==1) continue;
            cur_y=tmp_y;
        }
        else if(dir=="S"){
            if(dist>=park.size()-cur_y) continue;
            int tmp_y;
            for(tmp_y=cur_y+1;tmp_y<=cur_y+dist;tmp_y++){
                if(park[tmp_y][cur_x]=='X') {
                    flag=1;
                    break;
                }
            }
            if(flag==1) continue;
            cur_y=tmp_y-1;
        }
        else if(dir=="W"){
            if(dist>cur_x) continue;
            int tmp_x;
            for(tmp_x=cur_x;tmp_x>cur_x-dist;tmp_x--){
                if(park[cur_y][tmp_x-1]=='X') {
                    flag=1;
                    break;
                }
            }
            if(flag==1) continue;
            cur_x=tmp_x;
        }
        else if(dir=="E"){
            if(dist>= park[0].size()-cur_x) continue;
            int tmp_x;
            for(tmp_x=cur_x+1;tmp_x<=cur_x+dist;tmp_x++){
                if(park[cur_y][tmp_x]=='X') {
                    flag=1;
                    break;
                }
            }
            if(flag==1) continue;
            cur_x=tmp_x-1;
        }
    }
    answer.push_back(cur_y);
    answer.push_back(cur_x);
    return answer;
}