package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj2212 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), K = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		List<Integer> diff = new ArrayList<>();
		
		for(int i = 0 ; i < N; i++) {
			arr.add(sc.nextInt());
		}
		
		arr.sort(null);
		
		for(int i = 1 ; i < N; i++) {
			diff.add(arr.get(i) - arr.get(i-1));
		}
		
		diff.sort(null);
		//System.out.println(diff);
		
		int sum = 0;
		for(int i = 0; i < N - (K); i ++) sum+= diff.get(i);
		
		System.out.println(sum);
	}

}
