package sw1234;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			char[] input = sc.next().toCharArray();
			
			Stack<Integer> st = new Stack<Integer>();
			
			for(int i = N - 1; i >= 0; i--) {
				char c = input[i];
				if(!st.isEmpty() && st.peek() == c - '0') st.pop();
				else st.push(c - '0');
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			while(!st.isEmpty()) sb.append(st.pop());
			
			System.out.println(sb.toString());
		}
	}

}
