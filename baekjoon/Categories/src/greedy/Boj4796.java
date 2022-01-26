package greedy;

import java.util.Scanner;

public class Boj4796 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int l,p,v, i = 0;
		
		while(true) {
			i++;
			l = sc.nextInt();
			p = sc.nextInt();
			v = sc.nextInt();
			
			if(l == 0 && p == 0 && v == 0) break;
			
			int day = (v/p)*l + ((v%p < l)? v%p:l);
			
			System.out.printf("Case %d: %d\n", i, day);
		}
	}

}
