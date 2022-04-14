import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] q) {
        int[] ret = new int[q.length];
        int[][] arr = new int[rows][columns];
        int idx = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = idx++;
            }
        }
        
        for(int i = 0; i < q.length; i++){
            ret[i] = f(arr, q[i]);
        }
        
        return ret;
    }
    
    public static int f(int[][] arr, int[] q){
        int x1 = q[0] - 1, y1 = q[1] - 1, x2 = q[2] - 1, y2 = q[3] - 1;
        
        int now = arr[x1][y1];
        int ret = now;
        
        for(int y = y1 + 1; y <= y2; y++){
            int tmp = arr[x1][y];
            arr[x1][y] = now;
            now = tmp;
            ret = Math.min(ret, now);
        }
        
        for(int x = x1 + 1; x <= x2; x++){
            int tmp = arr[x][y2];
            arr[x][y2] = now;
            now = tmp;
            ret = Math.min(ret, now);
        }
        
        for(int y = y2 - 1; y >= y1 ; y--){
            int tmp = arr[x2][y];
            arr[x2][y] = now;
            now = tmp;
            ret = Math.min(ret, now);
        }
        
        for(int x = x2 - 1; x >= x1 ; x--){
            int tmp = arr[x][y1];
            arr[x][y1] = now;
            now = tmp;
            ret = Math.min(ret, now);
        }
        
        return ret;
    }
}