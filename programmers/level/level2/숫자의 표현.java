class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n/2; i++){
            int tmp = i;
            for(int j = i + 1; j <= n; j++){
                tmp += j;
                if(tmp == n) {
                    answer++;
                    break;
                } else if(tmp > n){
                    break;
                }
            }
        }
        answer++;
        return answer;
    }
}