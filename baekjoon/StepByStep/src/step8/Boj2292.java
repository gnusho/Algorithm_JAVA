package step8;

import java.util.Scanner;

public class Boj2292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//1 - 7 - 19 - 37
		// 6 12 18 => 계차수열
		// an = 1 + 3n^2 -3n
		
		int ret = 1;
		while(true) {
			if(n == 1) break;
			int x = (int) (Math.pow(ret, 2) * 3 - ret * 3 + 1);
			int y = (int) (Math.pow(ret-1, 2) * 3 - (ret-1) * 3 + 1);
			if(n > y && n <= x) break;
			ret++;
		}
		
		System.out.println(ret);
	}
}
