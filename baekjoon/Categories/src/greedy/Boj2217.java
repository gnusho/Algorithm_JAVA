package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj2217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), max = -1, cnt = N;
		List<Integer> rope = new ArrayList<>();
		
		for(int i = 0; i < N ; i++) {
			int tmp = sc.nextInt();
			rope.add(tmp);
		}
		
		rope.sort(null);
		
		for(int i = 0; i < N ; i++) {
			int x = cnt*rope.get(i);
			max = x > max? x:max;
			cnt--;
		}
		
		System.out.println(max);
	}

}
