function solution(s) {
    var answer = '';
    
    const list = s.split(' ').map(a => parseInt(a))
    
    list.sort((a,b) => a-b);
    
    answer +=list[0]  +' ' + list[list.length - 1];
    return answer;
}