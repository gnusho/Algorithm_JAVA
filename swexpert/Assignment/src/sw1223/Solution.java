package sw1223;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		Stack<Integer> st = new Stack<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력 받기
			int N = sc.nextInt();
			String input = sc.next();
	
			// 환경 설정
			q.clear();
			st.clear();
	
			// 중위 표기식의 후위 표기식 변환
			/*
			 * 1. 수식의 각 연산자에 대해서 우선 순위에 따라 괄호를 사용하여 다시 표현한다
			 * 2. 각 연산자를 그에 대응하는 오른쪽 괄호의 뒤로 이동시킨다
			 * 3. 괄호를 제거한다
			 */
			for(int i = 0; i < input.length(); i++) {
				int tmp = input.charAt(i);
				if(tmp >= '0' && tmp <= '9') {
					q.add(tmp - '0'); // 피연산자는 q에 그냥 집어넣는다
					if(!st.isEmpty() && st.peek() == '*') { // *=42, +=43
						q.add(st.pop()); // 숫자를 넣는데 top이 *면 집어넣는다
					}
				} else {
					st.push(tmp);
				}
			}
			
			// 나머지 더하기 모두 넣어주기
			while(!st.isEmpty()) {
				q.add(st.pop());
			}
			
			// 이제 q보면서 처리하기 그리고 이때 stack은 empty일 것이므로 재사용 가능
			/*
			 * 후위 표기법의 수식을 스택을 이용해서 계산
			 * 1. 피연산자를 만나면 스택에 push
			 * 2. 연산자를 만나면 필요한 만큼 피연산자를 pop하여 연산하고 연산결과를 스택에 push
			 * 3. 수식이 끝나면 남아있는 값을 pop하여 출력
			 */
			while(!q.isEmpty()) {
				int tmp = q.poll();
				if(tmp >= 0 && tmp <= 9) {
					st.push(tmp);
				} else if(tmp == '*') {
					int result = st.pop() * st.pop();
					st.push(result);
				} else if(tmp == '+') {
					int result = st.pop() + st.pop();
					st.push(result);
				}
			}
			
			System.out.printf("#%d %d\n", test_case, st.pop());
		}
	}
}

/*
 * <중위 표기식을 후위 표기식으로 바꾸는 것에 대한 고민>
 * 1. 얘네 결국엔 stack에 들어가야 된다
 * 2. String을 넣었다가 뺏다 해야된다. () 처리 때문에 -> 이걸 안할 수 있도록 머리를 써보자
 * 
 * 생각해보니까 교재의 설명으로부터 생각했을때, 이 문제는 결국 전체 괄호를 치면 모든 +는 밖으로 나오고 *만 안쪽으로 처리하면 되는 문제가 된다
 * 무슨 소리냐면 +는 계속 쌓아두고 *가 들어왔을 땐 다음숫자가 들어오면 바로 함께 집어넣어주겠다는 것
 * ex) 3*3*7*6*9*1*7 -> 33*7*6*9*1*7*
 */