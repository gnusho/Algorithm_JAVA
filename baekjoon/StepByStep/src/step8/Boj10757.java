package step8;

import java.io.*;
import java.util.*;

public class Boj10757 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken(), B = st.nextToken();
		String tmp = "";
		if(A.length() > B.length()) {
			for(int i = 0; i < A.length() - B.length(); i++) {
				tmp += "0";
			}
			B = tmp + B;
		} else {
			for(int i = 0; i < B.length() - A.length(); i++) {
				tmp+="0";
			}
			A = tmp + A;
		}
		int l = A.length()> B.length()? A.length(): B.length();
		int[] ret = new int[l + 1];
		
		int buffer = 0;
		for(int i = l-1;i>=0;i--) {
			int a = A.charAt(i) - (int)'0';
			int b = B.charAt(i) - (int)'0';
			//System.out.println(a + " " + b + " " + buffer);
			ret[i+1] = (a+b+buffer)%10;
			buffer = (a+b+buffer)/10; 
		}
		
		ret[0] = buffer;
		int start = 1;
		if(ret[0] != 0) start = 0;
		
		for(int i = start; i<ret.length;i++) {
			System.out.print(ret[i]);
		}
	}

}

//999999999999999 1
//1 999