package B03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		Stack<top> stack = new Stack<>();
		int[] input = new int[N];
		for(int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			int tmp = input[i];
			int index = 0;
			while(!stack.empty()) {
				if(stack.peek().h > tmp) {
					index = stack.peek().index;
					break;
				}
				
				stack.pop();
			}
			stack.push(new top(tmp, i + 1));
			System.out.print(index + " ");
		}
	}

}

class top{
	int h, index;
	top(int h, int index){
		this.h = h;
		this.index = index;
	}
}