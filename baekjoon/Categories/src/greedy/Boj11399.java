package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		List<Integer> arr = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}
		
		arr.sort(null);
		
		int sum = 0;
		for(int i = 0 ; i < arr.size(); i++) sum += N--*arr.get(i);
		
		System.out.println(sum);
	}

}
