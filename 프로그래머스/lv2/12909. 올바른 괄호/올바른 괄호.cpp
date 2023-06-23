#include<string>
#include <iostream>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    int a=0;
    
    for(int i=0;i<s.size();i++){
        if(a<0) break;
        if(s[i]=='('){
            a++;
        } else{
            a--;
        }
    }
    if(a==0) answer=true;
    else answer=false;
    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    cout << "Hello Cpp" << endl;

    return answer;
}