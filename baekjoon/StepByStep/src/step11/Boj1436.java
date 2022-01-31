package step11;

import java.util.Scanner;

public class Boj1436 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int x = 666, cnt = 1;
		
		while(cnt < N) {
			x++;
			int tmp = x, s_cnt = 0;
			while(tmp>0) {
				if(tmp%10 == 6) s_cnt++;
				else s_cnt = 0;
				
				if(s_cnt == 3) {
					cnt++;
					break;
				}
				tmp /= 10;
			}
		}
		
		System.out.println(x);
	}

}
