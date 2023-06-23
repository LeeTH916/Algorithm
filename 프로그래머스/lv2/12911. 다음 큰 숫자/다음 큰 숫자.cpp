#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(int n) {
    int answer = 0;
    bitset<20> b=n;
    int count=b.count();
    while(1){
        n++;
        b=n;
        if(count == b.count()) break;
    }
    answer=n;
    return answer;
}