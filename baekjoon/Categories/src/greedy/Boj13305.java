package greedy;

import java.util.Scanner;

public class Boj13305 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long[] dist = new long[N - 1];

		for (int i = 0; i < dist.length; i++) {
			dist[i] = sc.nextInt();
		}

		long min = 1000000001;
		long sum = 0;
		for (int i = 0; i < N; i++) {
			long p = sc.nextInt();
			if(i == N-1) continue;
			
			min = (min > p)? p:min;
			
			sum += min*dist[i];
		}
		
		System.out.println(sum);
	}

}
