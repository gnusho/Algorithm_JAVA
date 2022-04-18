package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj11663 {

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] points = new int[N];
		input = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			points[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(points);
		
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = lowerBound(points, Integer.parseInt(input[0]));
			int b = upperBound(points, Integer.parseInt(input[1]));
			sb.append(b-a).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static int lowerBound(int[] points, int target) {
		int start = 0;
		int end = points.length;
		
		while(end > start) {
			int mid = (start + end) / 2;
			if(points[mid] >= target) end = mid;
			else start = mid + 1;
		}
		
		return end;
	}
	
	private static int upperBound(int[] points, int target) {
		int start = 0;
		int end = points.length;
		
		while(end > start) {
			int mid = (start + end) / 2;
			if(points[mid] > target) end = mid;
			else start = mid + 1;
		}
		
		return end;
	}

}
