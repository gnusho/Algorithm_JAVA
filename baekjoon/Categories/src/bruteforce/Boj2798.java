package bruteforce;

import java.util.Scanner;

public class Boj2798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();

		int[] num = new int[N];

		for (int i = 0; i < N; i++)
			num[i] = sc.nextInt();
		
		int bj = -1;
		
		for(int i = 0; i < N -2; i++) {
			for(int j = i + 1; j < N-1; j++) {
				for(int t = j + 1; t < N; t++) {
					int tmp = num[i]+num[j]+num[t];
					if(tmp>M) continue;
					bj = bj<tmp? tmp:bj;
				}
			}
		}
		
		System.out.println(bj);
	}

}