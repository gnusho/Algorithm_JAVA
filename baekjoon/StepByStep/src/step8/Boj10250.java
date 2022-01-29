package step8;

import java.io.*;
import java.util.*;

public class Boj10250 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		int H, W, N;

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			int x = N / H + ((N % H == 0) ? 0 : 1);
			int y = (N % H == 0) ? H : N % H;

			String xx = ((x < 10) ? "0" : "") + x;

			System.out.println(y + xx);
		}
	}

}
