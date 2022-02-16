package string;

import java.util.Scanner;
import java.util.Stack;

public class Boj16120 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		if(ppap(input)) System.out.println("PPAP");
		else System.out.println("NP");
	}

	public static boolean ppap(String input) {
		boolean ret = true;
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i = 0; i < input.length(); i++) {
			int tmp = input.charAt(i);
			if(tmp == 'P') st.push(tmp);
			else if(tmp == 'A'){
				if(st.size() < 2 || i + 1 >= input.length() || input.charAt(i + 1) != 'P') {
					ret = false;
					break;
				} else {
					st.pop();
					i++;
				}
			}
		}
		
		if(st.size() > 1) ret = false;
		
		return ret;
	}
}
