import java.util.*;
import java.awt.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++) adjList[i] = new ArrayList<Integer>();
        
        for(int i = 0; i < edge.length; i++){
            int x = edge[i][0] - 1;
            int y = edge[i][1] - 1;
            
            adjList[x].add(y);
            adjList[y].add(x);
        }
        
        // BFS 구현
        boolean[] visit = new boolean[n];
        Queue<Integer> q = new LinkedList<Integer>();
        
        q.offer(0);
        visit[0] = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            answer = size;
            
            while(size-- > 0){
                int now = q.poll();
                
                for(int x: adjList[now]){
                    if(!visit[x]){
                        visit[x] = true;
                        q.offer(x);
                    }
                }
            }
        }
        
        return answer;
    }
}