package step9;

import java.util.Scanner;

public class Boj1978 {

	static boolean[] num = new boolean[1001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num[0] = true;
		num[1] = true;
		che();
		
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int N = sc.nextInt();
		while(N-->0) {
			if(num[sc.nextInt()] == false) cnt++;
		}
		System.out.println(cnt);
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
