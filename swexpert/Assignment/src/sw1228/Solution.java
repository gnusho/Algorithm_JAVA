package sw1228;

import java.util.LinkedList;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;
		LinkedList<Integer> ll = new LinkedList<Integer>();
		// 중간 중간에 삽입을 해야하는 것으로 보이므로 linkedlist를 사용하자
		
		for (int test_case = 1; test_case <= T; test_case++) {
			ll.clear(); // 이번엔 10개씩만 보여주므로 clear가 필수다
			int N = sc.nextInt();
			for(int i = 0 ; i < N; i++) {
				ll.add(sc.nextInt());
			}
			
			int M = sc.nextInt();
			for(int i = 0; i < M; i++) {
				String order = sc.next(); // 명령이 하나뿐인데 굳이 입력받으라고 함
				
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				for(int j = 0; j < y; j++) {
					ll.add(x++, sc.nextInt()); // 입력 받은 값을 순서대로 넣어줘야 하니까, x++
				}
			}
			
			System.out.print("#" + test_case);
			
			for(int i = 0; i < 10; i++){
				System.out.print(" " + ll.get(i));
			}
			
			System.out.println();
		}
	}
}
