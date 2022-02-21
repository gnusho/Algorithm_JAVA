package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj3190 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] arr = new int[N][N]; // 사과가 있는지 표시함
		
		while(K-- > 0) {
			int X = sc.nextInt() - 1;
			int Y = sc.nextInt() - 1;
			
			arr[X][Y] = -1; // -1은 사과 0은 그냥 1은 자기 몸
		}
		
		Deque<int[]> dq = new ArrayDeque<int[]>();
		
		int L = sc.nextInt();
		Queue<int[]> q = new LinkedList<int[]>();
		
		for(int i = 0; i < L; i++) {
			int[] tmp = new int[2];
			tmp[0] = sc.nextInt();
			tmp[1] = sc.next().charAt(0);
			q.offer(tmp);
		}
		
		int[] move_x = {0, 1, 0, -1};
		int[] move_y = {1, 0, -1, 0};
		
		int direction = 0, time = 0;
		int now_x = 0, now_y = 0; // 좌표
		dq.offerLast(new int[] {now_x, now_y});
		arr[now_x][now_y] = 1;
		
		while(true) {
			time++;
			
			// 한칸 씩 이동
			now_x += move_x[direction];
			now_y += move_y[direction];
			
			// 벽에 부딧쳤거나 자기 몸에 부딧치면 break
			if(now_x < 0 || now_y < 0 || now_x >= N || now_y >= N) break;
			else if(arr[now_x][now_y] == 1) break;
			
			// 아니면 우선 이동하고 사과 있는지 확인
			dq.offerFirst(new int[] {now_x, now_y});
			if(arr[now_x][now_y] == 0) {
				int[] tail = dq.pollLast();
				arr[tail[0]][tail[1]] = 0;
			}
			
			arr[now_x][now_y] = 1;
			
			if(!q.isEmpty() && time == q.peek()[0]) {// 방향 바뀌는건 X초가 끝난 뒤에
				
				if(q.peek()[1] == 'L') {
					direction = --direction<0? 3: direction;
				} else if(q.peek()[1] == 'D') {
					direction = ++direction%4;
				}
				
				q.remove();
			}
		}
		
		System.out.println(time);
	}

}
