package step9;

import java.util.Scanner;

public class Boj2581 {

	static boolean[] num = new boolean[10001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num[0] = true;
		num[1] = true;
		che();
		
		Scanner sc = new Scanner(System.in);
		int sum = 0, min = 0;
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		for(int i = M; i <= N; i++) {
			if(num[i] == false) {
				if(sum == 0) min = i;
				sum += i;
			}
		}
		
		if(sum == 0) System.out.println(-1);
		else {
			System.out.printf("%d\n%d", sum, min);
		}
	}
	
	public static void che() {
		for(int i = 2; i <num.length;i++) {
			if(num[i] == true) continue;
			
			for(int j = i*2; j <num.length; j +=i) {
				num[j] = true;
			}
		}
	}

}
