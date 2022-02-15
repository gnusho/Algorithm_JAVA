package string;

import java.util.Scanner;
import java.util.Stack;

public class Boj9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Stack<Integer> st = new Stack<Integer>();
		
		while(T-- > 0) {
			st.clear();
			String tmp = sc.next();
			
			boolean isVPS = true;
			
			for(int i = 0; i < tmp.length(); i++) {
				int temp = tmp.charAt(i);
				if(temp == '(') st.push(temp);
				else {
					if(st.isEmpty()) {
						isVPS = false;
						break;
					} else {
						st.pop();
					}
				}
			}
			
			if(!st.isEmpty()) isVPS = false;
			
			System.out.println(isVPS? "YES": "NO");
		}
	}

}
