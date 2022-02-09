package sw1224;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Solution {

	static Stack<Integer> st = new Stack<Integer>();
	static Queue<Integer> q = new LinkedList<Integer>();
	static String input;

	// 7*(6*8)+3 같은게 처리가 안됨 -> 숫자뿐만이 아니라 연산자를 만나도 *는 따로 처리해줘야함
	public static int parser(int start) {
		int i;
		Stack<Integer> stack = new Stack<Integer>(); // 특정 괄호 내부에서 사용된것만 처리
		for (i = start; i < input.length(); i++) {
			int tmp = input.charAt(i);
			if (tmp >= '0' && tmp <= '9') {
				q.add(tmp - '0');
				if (!stack.isEmpty() && stack.peek() == '*') {
					q.add(stack.pop());
				}
			} else if (tmp == '(') { // 괄호 또 보면 재귀 시작 그리고 )본 이후부터 다시 시작
				i = parser(i + 1);
			} else if (tmp == ')') { // 끝내버리고 i return 준비함
				break;
			} else {
				if (!stack.isEmpty() && stack.peek() == '*') {
					q.add(stack.pop());
				}
				stack.push(tmp);
			}
		}

		// 나머지 더하기 모두 넣어주기
		while (!stack.isEmpty()) {
			q.add(stack.pop());
		}

		return i;
	}

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력 받기
			int N = sc.nextInt();
			input = sc.next();

			// 환경 설정
			q.clear();
			st.clear();

			// 중위 표기식의 후위 표기식 변환
			/*
			 * 1. 수식의 각 연산자에 대해서 우선 순위에 따라 괄호를 사용하여 다시 표현한다 
			 * 2. 각 연산자를 그에 대응하는 오른쪽 괄호의 뒤로이동시킨다 
			 * 3. 괄호를 제거한다
			 */
			
			// 괄호가 계속 나오니까 이건 재귀가 맞지 않을까?
			parser(1);

			/*
			 * 후위 표기법의 수식을 스택을 이용해서 계산 
			 * 1. 피연산자를 만나면 스택에 push 
			 * 2. 연산자를 만나면 필요한 만큼 피연산자를 pop하여 연산하고 연산결과를 스택에 push 
			 * 3. 수식이 끝나면 남아있는 값을 pop하여 출력
			 */
			while (!q.isEmpty()) {
				int tmp = q.poll();
				if (tmp >= 0 && tmp <= 9) {
					st.push(tmp);
				} else if (tmp == '*') {
					int result = st.pop() * st.pop();
					st.push(result);
				} else if (tmp == '+') {
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
 * 2. String을 넣었다가 뺏다해야된다. () 처리 때문에 -> 이걸 안할 수 있도록 머리를 써보자
 * 이번엔 괄호가 존재한다. 이 괄호를 가지고 어떻게 저렇게 해야한다.
 */