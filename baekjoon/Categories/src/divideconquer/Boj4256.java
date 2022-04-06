package divideconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj4256 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] preorder = new int[N];
			int[] preplace = new int[N];
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				preorder[i] = Integer.parseInt(input[i]) - 1;
				preplace[preorder[i]] = i;
			}

			int[] inorder = new int[N];
			int[] inplace = new int[N];
			input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				inorder[i] = Integer.parseInt(input[i]) - 1;
				inplace[inorder[i]] = i;
			}

			int[][] tree = new int[N][2];
			int root = dq(tree, preorder, preplace, inorder, inplace, 0, 0, N);
			
			StringBuilder sb = new StringBuilder();
			postorder(sb, tree, root);
			System.out.println(sb.toString());
		}
	}

	// 후위 순회 구현
	public static void postorder(StringBuilder sb, int[][] tree, int now) {
		if(tree[now][0] >= 0) {
			postorder(sb, tree, tree[now][0]);
		}
		if(tree[now][1] >= 0) {
			postorder(sb, tree, tree[now][1]);
		}
		sb.append(now + 1).append(" ");
	}
	
	// 해당 범위에서 root를 찾아서 return 한다.
	public static int dq(int[][] tree, int[] pre, int[] preplace, int[] in, int[] inplace, int pNow, int iStart, int iEnd) {
		
		if(pNow < 0 || pNow >= pre.length) return -1;
		int now = pre[pNow];
		int dividePoint = inplace[now];
		
		int leftP = pre.length;
		for(int i = iStart; i < dividePoint; i++) {
			leftP = Math.min(leftP, preplace[in[i]]);
		}
		tree[now][0] = dq(tree, pre, preplace, in, inplace, leftP, iStart, dividePoint);
		
		int rightP = pre.length;
		for(int i = dividePoint + 1; i < iEnd; i++) {
			rightP = Math.min(rightP, preplace[in[i]]);
		}
		tree[now][1] = dq(tree, pre, preplace, in, inplace, rightP, dividePoint + 1, iEnd);
		
		return now;
	}
}
