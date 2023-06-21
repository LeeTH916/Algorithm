#include <string>
#include <vector>
#include <iostream>
#include <cmath>

using namespace std;

long long solution(int r1, int r2) {
    long long answer = 0;
    answer += r2-r1+1;
    for(int i=1;i<r2;i++)
    {
        int b=floor(sqrt((long long)r2*r2 - (long long)i*i));
        int s=ceil(sqrt((long long)r1*r1-(long long)i*i));
        if(i<r1){
            answer+=b-s+1;
        }
        else{
            answer+=b;
        }
    }
    answer*=4;
    return answer;
}