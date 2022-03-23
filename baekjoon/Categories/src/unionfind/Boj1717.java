package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1717 {

	static int[] arr;
	
	public static int find(int a) {
		if(arr[a] == a) return a;
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
		arr[b] = a;
	}
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		arr = new int[N + 1];
		for(int i = 1; i <= N; i++) arr[i] = i;
		
		while(M-- > 0) {
			input = br.readLine().split(" ");
			int order = Integer.parseInt(input[0]);
			int x = Integer.parseInt(input[1]);
			int y = Integer.parseInt(input[2]);
			if(order == 1) {
				if(find(x) == find(y)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			} else {
				merge(x,y);
			}
		}
		
		System.out.println(sb.toString());
	}

}
