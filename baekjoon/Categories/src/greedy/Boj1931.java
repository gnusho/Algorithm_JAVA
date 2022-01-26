package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Boj1931 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), max = 0;
		List<C> c = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
			c.add(new C(sc.nextLong(), sc.nextLong()));

		Collections.sort(c);
		
		//System.out.println(c);
		
		long end = -1;
		for(int i = 0; i < N; i++) {
			long start = c.get(i).start;
			if(start < end) continue;
			
			max++;
			
			end = c.get(i).end;
		}
		
		System.out.println(max);
		
	}

}


class C implements Comparable<C>{
	long start, end;
	
	public C(long start, long end) {
		// TODO Auto-generated constructor stub
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(C c) {
		if(this.end > c.end) return 1;
		else if(this.end < c.end) return -1;
		else {
			if(this.start > c.start) return 1;
			else if(this.start < c.start) return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return start + ":" + end;
	}
	
}