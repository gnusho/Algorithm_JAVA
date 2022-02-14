package B07;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			int minus = sc.nextInt();
			list.add(i - minus, i + 1); // 말그대로 지금 들어간 위치에서 input만큼 빼준자리로 들어간다.
			// 다행히 아무것도 없어도 작동한다
		}
		
		for(int i = 0; i < N; i++)
			System.out.print(list.get(i) + " ");
	}

}
