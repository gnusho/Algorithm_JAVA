import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Integer> st = new Stack<>();
        char[] arr = s.toCharArray();
        
        for(int x: arr){
            if(st.isEmpty()) st.push(x);
            else {
                if(x == st.peek()) st.pop();
                else st.push(x);
            }
        }
        
        if(st.size() == 0) return 1;
        return 0;
    }
}