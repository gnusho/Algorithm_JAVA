package sw1218;
//배열로 푼 버전

import java.util.Scanner;
import java.util.Stack;

class Solution1 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int cnt = 0;

			String tmp = sc.next();
			int bracket[] = { 0, 0, 0, 0 };

			for (int i = 0; i < N; i++) {
				int temp = tmp.charAt(i);

				if (temp == '{')
					bracket[0]++;
				else if (temp == '[')
					bracket[1]++;
				else if (temp == '(')
					bracket[2]++;
				else if (temp == '<')
					bracket[3]++;
				else {
					int index = -1;
					if (temp == '}')
						index = 0;
					else if (temp == ']')
						index = 1;
					else if (temp == ')')
						index = 2;
					else if (temp == '>')
						index = 3;
					
					if(bracket[index] < 1) cnt++;
					else bracket[index]--;
				}
			}

			for(int k: bracket) cnt+=k;
			
			System.out.printf("#%d %d\n", test_case, cnt==0? 1:0);
		}
	}

}
//stack을 사용했다고 치고 바로바로 확인하는 것이 없을까?
//밑의 예제를 처리하기 위해선 어떻게 해야하는가
//짝을 찾을 때까지 전부 stack을 빼는건 그냥 배열로도 할 수 있는 일이다
//아 그냥 종료별로 stack을 받으면 되니까 stack을 4개를 만들자!
//근데 그럴바엔 배열로 {[(< 개수 세는게 나을듯? 이걸로 채택
/*
* 8 {[<((>]} 10 {[<(()>(]}( 8 {[<(}]>)
*/
