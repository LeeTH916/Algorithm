function solution(n) {
    var answer = 0;
    
    while(true){
        answer ++;
        if(n % answer === 1){
            return answer;
        }
    }
}