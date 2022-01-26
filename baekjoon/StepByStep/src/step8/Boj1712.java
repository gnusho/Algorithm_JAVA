package step8;

import java.util.Scanner;

public class Boj1712 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt(),B = sc.nextInt(),C = sc.nextInt();
		
		if(B >= C) System.out.println(-1);
		else {
			double x = (1.0*A/(C-B));
			if(x == Math.ceil(x)) System.out.println((int)x+1);
			else System.out.println((int)Math.ceil(x));
		}
	}

}
