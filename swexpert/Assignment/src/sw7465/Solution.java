package sw7465;

import java.util.Scanner;

public class Solution {

	static int N, M, ans;
	static int arr[];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			setArr();
			ans = N; // ans는 결과적으로 집합의 수 초기에는 각각이 다 다른 집합임
			while(M-- > 0) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				
				merge(X - 1,Y - 1); // 집합들이 합쳐지기 시작
			}
			
			System.out.printf("#%d %d\n", test_case, ans);
		}

	}

	public static int find(int a) {
		if(arr[a] == a) return a;
		return arr[a] = find(arr[a]);
	}
	
	public static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(b < a) { // 값을 항상 작은게 우선 나오도록 만드는 장치
			int tmp = b;
			b = a;
			a = tmp;
		}
		
		if(a != b) { // a와 b가 달라서 합칠 때만 cnt를 1씩 깍아준다.
			ans--;
			arr[b] = a;
		}
	}
	
	public static void setArr() {
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i;
		}
	}
	
}
