package step9;

import java.util.Scanner;

public class Boj3009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] xx = new int[3];
		int[] yy = new int[3];
		
		for(int i =0;i<3;i++) {
			xx[i] = sc.nextInt();
			yy[i] = sc.nextInt();
		}
		
		int idx_x = 0, idx_y = 0;
		
		if(xx[0] == xx[1]) idx_x=2;
		else if(xx[0] == xx[2]) idx_x=1;
		
		if(yy[0] == yy[1]) idx_y=2;
		else if(yy[0] == yy[2]) idx_y=1;
		
		System.out.printf("%d %d\n", xx[idx_x], yy[idx_y]);
	}

}
