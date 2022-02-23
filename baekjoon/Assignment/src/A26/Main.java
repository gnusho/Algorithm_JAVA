package A26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static int ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[][] arr = new int[N][N];
		
		List<int[]> homeList = new ArrayList<int[]>(); // 몇개인지 모름!
		List<int[]> chickenList = new ArrayList<int[]>(); // 몇개인지 모름!
		
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				if(arr[i][j] == 2) chickenList.add(new int[] {i, j});
				if(arr[i][j] == 1) homeList.add(new int[] {i, j});
			}
		}
		
		ans = N * N * N;
		boolean[] check = new boolean[chickenList.size()]; // 이걸로 조합을 표시함
		combination(homeList, chickenList, check, 0, 0, M, N);
		
		System.out.println(ans);
	}

	public static void combination(List<int[]> homeList, List<int[]> chickenList, boolean[] check, int now, int cnt, int M, int N) {
		// cnt가 M과 같으면 전체를 돌면서 검사하고 return
		if(cnt == M) {
			int sum = 0;
			// 각 집의 치킨에 대한 최소거리 구하기
			for(int[] home: homeList) {
				int min = N*N*N;
				for(int i = 0; i < check.length; i++) {
					if(check[i]) {
						int[] chicken = chickenList.get(i);
						min = Math.min(min, Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]));
					}
				}
				sum += min;
			}
			ans = Math.min(sum, ans);
			return;
		} else if (now >= check.length || cnt > M){// now가 check.size보다 크거나 cnt가 M보다 크면 return
			return;
		}
		// 재귀 생성
		check[now] = true;
		combination(homeList, chickenList, check, now + 1, cnt + 1, M, N);
		check[now] = false;
		combination(homeList, chickenList, check, now + 1, cnt, M, N);
	}
}
// 치킨 거리 = 집에서 가장 가까운 치킨집 사이의 거리 => 도시의 치킨거린 = 모든 집의 치킨 거리의 합
// 거리는 해밀턴 거리
// M개의 치킨집을 놔둘거라고 함
// DFS를 해서 간단하게 구현은 가능할 듯 하지만 경우의수가 그게 되나? 13C6 = 1716이라 가능할듯하다
// 최악의 연산을 계산해보면 13C6 * 6 * 100 = 1716 * 600 = 1029600 (백만)
// 하면 될듯 하다.
// 결과적으로 조합을 구하고 해당 조합에서 도시의 치킨거리를 구해서 처리할 수 있다