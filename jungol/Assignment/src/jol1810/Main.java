package jol1810;

import java.util.*;

public class Main {

	static List<Integer> list = new ArrayList<>();
	static boolean[] check = new boolean[9];
	static boolean done = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			list.add(sc.nextInt());
		}

		list.sort(null);
		recur(0, 0, 0);
		
		for(int i = 0 ; i < 9; i++) {
			if(check[i]) System.out.println(list.get(i));
		}
	}

	public static void recur(int sum, int cnt, int now) {
		//System.out.println(sum + " " + cnt + " " + now);
		if (sum == 100 && cnt == 7) {
			done = true;
			return;
		}
		
		if (cnt > 7 || sum > 100 || now >= 9)
			return;

		check[now] = true;
		recur(sum + list.get(now), cnt + 1, now + 1);
		if(done) return;
		check[now] = false;
		recur(sum, cnt, now + 1);
		
	}
}
