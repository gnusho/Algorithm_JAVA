package sw3289;

import java.util.Scanner;

public class Solution {

	static int N, M, arr[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			setArr();
			
			StringBuilder sb = new StringBuilder();
			
			while(M-- > 0) {
				int order = sc.nextInt();
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				
				if(order == 0) merge(a,b);
				else if(order == 1) {
					if(checkSet(a, b)) sb.append(1);
					else sb.append(0);
				}
			}
			System.out.println("#" + test_case + " " + sb.toString());
		}
	}
	
	public static void setArr() {
		arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = i;
	}
	
	public static int find(int a) {
		if(a == arr[a]) return a;
		return arr[a] = find(arr[a]);
	}
	
	public static void merge(int a, int b) { // 이걸 boolean으로 하기엔 얘넨 다르면 합쳐버리니까 적합하지 않음
		a = find(a);
		b = find(b);
		
		if(b < a) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		if(a != b) {
			arr[b] = a;
		}
	}

	public static boolean checkSet(int a, int b) { // 정말 별차이 없이 여기서 각각의 root가 같은지 확인하는 코드만 새로 만듬
		a = find(a);
		b = find(b);
		
		if(a == b) return true;
		return false;
	}
}
