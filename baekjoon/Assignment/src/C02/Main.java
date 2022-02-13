package C02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long ans1 = 0, ans2 = 0;
		int ones = 0, zeros = 0;

		// 이진수가 연순으로 배열되어 있음
		List<Integer> list = new ArrayList<Integer>();

		while (A > 0) {
			int tmp = (int) (A % 2);
			list.add(tmp);
			if(tmp == 1) ones++;
			else zeros++;
			A /= 2;
		}

		// 작은 수 중에 큰 수 찾기 -> 10 이런거 찾기
		int index = -1, x_cnt = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == 0 && list.get(i + 1) == 1) {
				index = i;
				break;
			} else if(list.get(i) == 1) {
				x_cnt++;
			}
		}
		
		if(index < 0) {
			ans1 = 0;
		} else { // 
			long two = 1;
			for(int i = 0; i < list.size(); i++) {
				if ( i >= index - x_cnt && i < index + 1) ans1 += two;
				else if ( i > index + 1) ans1 += list.get(i) * two;
				
				two *= 2;
			}
		}
		
		// 큰 수 중에 작은 수 찾기 -> 01 이런거 찾기
		index = -1; 
		x_cnt = 0;
		list.add(0);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == 1 && list.get(i + 1) == 0) {
				index = i;
				break;
			} else if(list.get(i) == 1) {
				x_cnt++;
			}
		}
		
		long two = 1;
		for(int i = 0; i < list.size(); i++) {
			if(i < x_cnt || i == index + 1) ans2 += two;
			else if(i > index + 1) ans2 += list.get(i)*two;
			two *= 2;
		}

		System.out.printf("%d %d", ans1, ans2);
	}

}

// 775
// 43
// 15