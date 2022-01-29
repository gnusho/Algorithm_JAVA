package step8;

import java.io.*;
import java.util.*;

public class Boj2839 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int ret = -1, i = 0;
		
		while(true) {
			if(3*i > N) break;
			else if((N - 3*i)%5==0) {
				ret = i + (N - 3*i)/5;
				break;
			}
			i++;
		}
		
		System.out.println(ret);
	}

}
