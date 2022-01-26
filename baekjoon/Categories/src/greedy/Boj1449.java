package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj1449 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> place = new ArrayList<>();
		
		int N = sc.nextInt(),L = sc.nextInt(), ret = 0;
		boolean[] check = new boolean[N];
		
		for(int i = 0; i < N; i++)place.add(sc.nextInt());
		
		place.sort(null);
		
		for(int i = 0; i < N; i++) {
			if(check[i] == true) continue;
			int tmp = place.get(i);
			ret++;
			for(int j = i+1; j < N; j++) {
				if(place.get(j) - tmp < L)check[j] = true;
				else break;
			}
		}
		
		System.out.println(ret);
	}

}
