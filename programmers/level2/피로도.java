class Solution {
    
    static int ret = 0; // 최대 던전수
    static boolean visit[];
    
    public int solution(int k, int[][] d) {

        visit = new boolean[d.length];
        
        for(int i = 0; i < d.length; i++){
            dfs(k,d,0);
        }
        return ret;
    }
    
    public static void dfs(int k, int[][] d, int cnt){
        
        ret = Math.max(ret, cnt);
        if(cnt >= d.length) return;
        
        for(int i = 0; i < d.length; i++){
            if(!visit[i] && k >= d[i][0]){
                visit[i] = true;
                dfs(k - d[i][1], d, cnt + 1);
                visit[i] = false;
            }
        }
    }
}