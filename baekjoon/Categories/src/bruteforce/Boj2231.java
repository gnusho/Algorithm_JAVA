package bruteforce;

import java.util.Scanner;

public class Boj2231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int c = 0;
		for(int i = 1; i < N; i++) {
			int n = i, tmp = i;
			while(n > 0) {
				tmp += n%10;
				n/=10;
			}
			if(tmp == N) {
				c = i;
				break;
			}
		}
		
		System.out.println(c);
	}

}