function solution(s) {
    const arr = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    let answer = "";
    let key = "";
    for(let i = 0; i < s.length; i++) {
        if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            answer += s.charAt(i);
        } else {
            key += s.charAt(i);
            if (arr.includes(key)) {
                answer += arr.indexOf(key);
                key = "";
            }
        }
    }
    return Number(answer);
}