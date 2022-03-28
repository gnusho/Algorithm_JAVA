package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj20040 {

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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = i;
		
		int ret = 0;
		for(int i = 1; i <= M; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			
			if(ret == 0 && find(x) == find(y)) {
				ret = i;
			}
			merge(x,y);
		}
		
		System.out.println(ret);
	}

}
