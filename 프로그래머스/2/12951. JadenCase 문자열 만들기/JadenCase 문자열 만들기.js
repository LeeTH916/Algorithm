function solution(s) {
    var answer = '';
    
    const list = s.split(' ').map(a => {
        if(a !== '') return a[0].toUpperCase() + a.slice(1).toLowerCase();
    });
    answer = list.join(' ');
    return answer;
}