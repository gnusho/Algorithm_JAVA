class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return cnt;
    }
    
    public static void dfs(int[] numbers, int target, int now, int sum){
        if(now == numbers.length){
            if(sum == target) cnt++;
            return;
        }
        
        dfs(numbers, target, now+1, sum + numbers[now]);
        dfs(numbers, target, now+1, sum - numbers[now]);
    }
}