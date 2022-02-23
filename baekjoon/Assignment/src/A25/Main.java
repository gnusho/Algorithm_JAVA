package A25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];

		int fishes = 0;
		int now_x = 0, now_y = 0;
		int[] move_x = {-1, 1, 0, 0};
		int[] move_y = {0, 0, -1, 1};
		
		for(int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				if(arr[i][j] > 0 && arr[i][j] < 9) fishes++;
				else if(arr[i][j] == 9) {
					now_x = i;
					now_y = j;
				}
			}
		}
		arr[now_x][now_y] = 0; // 어차피 값 있는데 이걸 매번 바꿔줄 필요가 있냐?
		// 루프
		// BFS 실행
		// 확인 -> break 조건은 fishes가 감소하지 않았을 때 또는 fishes 값이 0일때
		int cnt = 0;
		int sharkSize = 2;
		int eatFishCount = 0;
		while(true) {
			int fish_x = N + 1, fish_y = N + 1; // 해당 depth에서 내가 처리할 물고기의 위치
			
			boolean visited[][] = new boolean[N][N];
			Queue<int[]> q = new LinkedList<int[]>();
			q.offer(new int[] {now_x, now_y});
			visited[now_x][now_y] = true;
			
			int depth = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				depth++; // 원래는 정의상 맞지 않으니 어차피 나오면 바로 break라서 그냥 1부터 시작함
				for(int i = 0; i < size; i++) {
					int[] tmp = q.poll();
					
					for(int j = 0; j < 4; j++) {
						int tmp_x = tmp[0] + move_x[j];
						int tmp_y = tmp[1] + move_y[j];
						
						if(tmp_x < 0 || tmp_y < 0 || tmp_x >= N || tmp_y >= N || visited[tmp_x][tmp_y]) continue;
						
						// 여기서 값 보면서 처리
						// 값이 0일 때 -> 그냥 q에 넣어줌
						// 1 ~ 6일 때 -> 크면 continue 작으면 먹고 자리 0으로 바꾸고 for문 전체 break 같으면 지나감
						if(arr[tmp_x][tmp_y] == 0 || arr[tmp_x][tmp_y] == sharkSize) {
							q.offer(new int[] {tmp_x, tmp_y});
							visited[tmp_x][tmp_y] = true;
						}
						else if(arr[tmp_x][tmp_y] > sharkSize) continue;
						else { // 값이 작을 때 가장 위에 있는 것부터 처리하고 가장 위에 있는게 여러개라면 왼쪽부터 처리
							if(tmp_x < fish_x || (tmp_x == fish_x && tmp_y < fish_y)) {
								fish_x = tmp_x;
								fish_y = tmp_y;
							}
						}
					}
				}
				
				if(fish_x < N) break; 
			}
			
			if(fish_x > N) break;
			else {
				arr[fish_x][fish_y] = 0;
				cnt += depth;
				eatFishCount++;
				fishes--;
				now_x = fish_x;
				now_y = fish_y;
				
				if(eatFishCount == sharkSize) {
					eatFishCount = 0;
					sharkSize++;
				}
				if(fishes == 0) break;
			}
		}
		
		System.out.println(cnt);
	}

}
// 매번 표 전체를 검사하면서 갈 곳을 선택할 수 있을까? 갈 수 있을지 없을지 몰라서 불가능하다.
// 즉 한칸씩 이동을 해봐야한다 -> BFS를 반복하자!!
// 이 해당 BFS를 돌릴 때 마다 visit배열을 초기화 해주고 한번 갔던 경로로는 못가도록 해야함 왜냐하면 이건 항상 그자리에서 최선을 찾기 때문