package bfsdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj20304 {

	public static void main(String[] args) {
		
		Queue<T> q = new LinkedList<T>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		boolean check[] = new boolean[N + 1]; // 값은 어차피 while문 안에서 비교할건데 왜 니가 int야? 왜 굳이 초기화해? 왜 굳이 돌면서 max 찾아?
		
		while(M-- > 0) {
			int tmp = sc.nextInt();
			q.offer(new T(tmp, 0)); // 바로 바로 넣어주기
			check[tmp] = true; // 들어가면서 체크해줘야함 아니면 입력값이 큐에 한번 더 들어갈 수도 있음
		}
		int max = -1; // 이거 답이 될 예정
		
		while(!q.isEmpty()) {
			
			T now = q.poll(); // pop!
			
			max = Math.max(max, now.depth); // max 값 갱신
			
			for(int compare = 1; compare <= N; compare <<= 1) { // 비트를 한칸씩 오른쪽으로 이동하면서
				
				// now.index & compare가 0이면 없는거다 그러니까 더해줘야지
				int next = (now.index & compare) == 0? now.index + compare: now.index - compare;
				
				if(next <= N && !check[next]) {
					q.offer(new T(next, now.depth + 1));
					check[next] = true; // 들어가면서 체크해줘야함 아니면 입력값이 큐에 한번 더 들어갈 수도 있음
				}
				
			}
			
		}
		
		System.out.println(max); // 답 출력
		
	}
	
	static class T {
		int index;
		int depth;
		
		T(int index, int depth) {
			this.index = index;
			this.depth = depth;
		}
	}

}
