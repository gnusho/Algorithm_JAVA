package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17352 {

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
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = i;
		
		String[] input;
		for(int i = 0; i < N - 2; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]) - 1;
			int y = Integer.parseInt(input[1]) - 1;
			
			merge(x,y);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(find(i) != find(j)) {
					System.out.println((i+1) + " " + (j+1));
					return;
				}
			}
		}

	}

}
