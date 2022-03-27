package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj17398 {

	static int[] arr;
	static int[][] edges;
	static boolean[] cut;
	
	public static int find(int a) {
		if(arr[a] < 0) return a;
		else return arr[a] = find(arr[a]);
	}
	
	public static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		if(a==b) return;
		arr[a] += arr[b];
		arr[b] = a;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int Q = Integer.parseInt(input[2]);
		
		arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = -1;
		edges = new int[M][2];
		cut = new boolean[M];
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			edges[i][0] = Integer.parseInt(input[0]) - 1;
			edges[i][1] = Integer.parseInt(input[1]) - 1;
		}

		for(int i = 0; i < Q; i++) {
			int x = Integer.parseInt(br.readLine()) - 1;
			cut[x] = true;
			st.push(x);
		}
		
		for(int i = 0; i < M; i++) {
			if(cut[i]) continue;
			merge(edges[i][0], edges[i][1]);
		}
		
		long ret = 0;
		while(!st.isEmpty()) {
			int now = st.pop();
			int x = edges[now][0];
			int y = edges[now][1];
			if(find(x) != find(y)) {
				ret += arr[find(x)]*arr[find(y)];
			}
			merge(x,y);
		}
		
		System.out.println(ret);
	}

}
