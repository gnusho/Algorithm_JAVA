import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<HashSet<Integer>> list = new ArrayList<>();
        int x = 0;
        for(int n = 1; n <= 8; n++){
            HashSet<Integer> tmp = new HashSet<>();
            x = x * 10 + N;
            tmp.add(x);
            
            for(int m = 1; m < n; m++){
                HashSet<Integer> setA = list.get(m - 1);
                HashSet<Integer> setB = list.get(n - m - 1);
                
                for(int a: setA){
                    for(int b: setB){
                        tmp.add(a + b);
                        if(a - b > 0) tmp.add(a - b);
                        if(b != 0 && a / b > 0) tmp.add(a/b);
                        if(a * b <= 32000) tmp.add(a*b);
                    }
                }
            }
            list.add(tmp);
        }
        
        for(int ret = 0; ret < list.size(); ret++){
            if(list.get(ret).contains(number)){
                return ret + 1;
            }
        }
        
        return -1;
    }
}