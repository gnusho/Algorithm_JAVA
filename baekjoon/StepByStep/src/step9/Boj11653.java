package step9;

import java.util.Scanner;

public class Boj11653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), end = N;
		
		for(int i = 2; i < end + 1; i++) {
			if(N <= 1) break;
			while(N%i == 0) {
				System.out.println(i);
				N/=i;
			}
		}
	}

}
