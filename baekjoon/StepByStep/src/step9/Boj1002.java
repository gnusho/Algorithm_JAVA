package step9;

import java.util.Scanner;

public class Boj1002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		double x1, y1, r1, x2, y2, r2;
		
		while (T-- > 0) {
			x1 = sc.nextDouble(); 
			y1 = sc.nextDouble(); 
			r1 = sc.nextDouble(); 
			x2 = sc.nextDouble(); 
			y2 = sc.nextDouble(); 
			r2 = sc.nextDouble();
			
			double tmp = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
			
			if(tmp == 0 && r1 == r2) System.out.println(-1);
			else if(tmp > r1+r2) System.out.println(0);
			else if(tmp == r1 + r2) System.out.println(1);
			else if(tmp > Math.abs(r1-r2)) System.out.println(2);
			else if(tmp == Math.abs(r1-r2)) System.out.println(1);
			else System.out.println(0);
		}
	}

}
