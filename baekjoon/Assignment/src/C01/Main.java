package C01;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();

		for(int i = 0 ; i < 10; i++) pq1.offer(-sc.nextInt());
		for(int i = 0 ; i < 10; i++) pq2.offer(-sc.nextInt());
		
		System.out.print(-(pq1.poll() + pq1.poll() + pq1.poll()));
		System.out.print(" ");
		System.out.print(-(pq2.poll() + pq2.poll() + pq2.poll()));
	}

}
