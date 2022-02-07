// 스택으로 푼 버전
package sw1218;

import java.util.Scanner;
import java.util.Stack;

class Solution2 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int cnt = 0;

			String tmp = sc.next();
			Stack<Integer> st0 = new Stack<>();
			Stack<Integer> st1 = new Stack<>();
			Stack<Integer> st2 = new Stack<>();
			Stack<Integer> st3 = new Stack<>();
			
			for (int i = 0; i < N; i++) {
				int temp = tmp.charAt(i);

				if (temp == '{')
					st0.add(temp);
				else if (temp == '[')
					st1.add(temp);
				else if (temp == '(')
					st2.add(temp);
				else if (temp == '<')
					st3.add(temp);
				else {
					int index = -1;
					if (temp == '}') {
						if(st0.size() < 1) cnt++;
						else st0.pop();
					} else if (temp == ']') {
						if(st1.size() < 1) cnt++;
						else st1.pop();
					} else if (temp == ')') {
						if(st2.size() < 1) cnt++;
						else st2.pop();
					} else if (temp == '>') {
						if(st3.size() < 1) cnt++;
						else st3.pop();
					}
					
				}
			}

			cnt += st0.size() + st1.size() + st2.size() + st3.size();
			
			System.out.printf("#%d %d\n", test_case, cnt==0? 1:0);
		}
	}

}
//stack을 사용했다고 치고 바로바로 확인하는 것이 없을까?
// 밑의 예제를 처리하기 위해선 어떻게 해야하는가
// 짝을 찾을 때까지 전부 stack을 빼는건 그냥 배열로도 할 수 있는 일이다
// 아 그냥 종료별로 stack을 받으면 되니까 stack을 4개를 만들자!
// 근데 그럴바엔 배열로 {[(< 개수 세는게 나을듯? 이걸로 채택
/*
 * 8 {[<((>]} 10 {[<(()>(]}( 8 {[<(}]>)
 */
