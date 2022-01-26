package greedy;

import java.util.Scanner;

public class Boj11047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(),K = sc.nextInt(), cnt = 0;
		int[] coin = new int[N];
		
		for(int i = 0; i < N ; i++) coin[i] = sc.nextInt();
		
		for(int i = N-1; i >= 0; i--) {
			if(coin[i] > K) continue;
			cnt += K/coin[i];
			K -= (K/coin[i])*coin[i];
		}
		
		System.out.println(cnt);
	}

}
