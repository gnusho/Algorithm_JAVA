package step8;

import java.io.*;
import java.util.*;

public class Boj1011 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {

			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());

			long tmp = y - x;
			System.out.println(func(tmp));
		}
	}

	public static long func(long tmp) {
		if (tmp == 1)
			return 1;

		boolean c = false; // true: x++, false: y++
		long x = 1, y = 1; // x <= y 항상

		while (true) {
			if (c) {
				if (tmp <= (x + 1) * y && tmp > x * y) {
					break;
				}
				x++;
			} else {
				if (tmp <= (y + 1) * x && tmp > x * y) {
					break;
				}
				y++;
			}
			c = !c;
		}
		//System.out.println(x + "" + y);
		return x + y;
	}

}

//0 -> 3 : 1,1,1
//1 -> 5 : 1,2,1
//45 -> 50 : 1,2,1,1
/*
 * 1
 * 11
 * 121
 * 1221
 * 12321
 * 홀수 짝수가 다름
 */
*/