package step7;

import java.util.Scanner;

public class Boj1316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		boolean[] alpha = new boolean[26]; 
		
		int t = sc.nextInt();
		while(t-- > 0) {
			for(int i = 0 ; i < alpha.length; i++) alpha[i] = false;
			String x = sc.next();
			boolean isGroup = true;
			for(int i = 0; i < x.length(); i++) {
				int tmp = x.charAt(i);
				
				if(alpha[tmp - 'a']) {
					if(tmp == x.charAt(i-1)) continue;
					else {
						isGroup = false;
						break;
					}
				}
				else {
					alpha[tmp - 'a'] = true;
				}
			}
			
			if(isGroup) cnt++;
		}
		System.out.println(cnt);
	}

}
