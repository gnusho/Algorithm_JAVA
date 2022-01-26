package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj11000 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), cnt = 0;
		List<CC> c = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
			c.add(new CC(sc.nextInt(), sc.nextInt()));

		Collections.sort(c);
		//System.out.println(c);
		
		PriorityQueue<CC> pq = new PriorityQueue<>(new Comparator<CC>() {
		    @Override
		    public int compare(CC c1, CC c2) {
		    	if(c1.end > c2.end) return 1;
				else if(c1.end < c2.end) return -1;
				else {
					if(c1.start > c2.start) return 1;
					else if(c1.start < c2.start) return -1;
				}
				return 0;
		    }
		});
		
		for(int i = 0; i < N; i++) {
			CC tmp = c.get(i);
			
			if(i == 0) {
				cnt++;
				pq.add(tmp);
				continue;
			}
			CC top = pq.peek();
			//System.out.print(tmp);
			//System.out.println(top);
			if(top.end > tmp.start) cnt++;
			else pq.remove();
			pq.add(tmp);
			//System.out.println(cnt);
		}
		
		
		System.out.println(cnt);
		
	}

}

class CC implements Comparable<CC>{
	int start, end;
	
	public CC(int start, int end) {
		// TODO Auto-generated constructor stub
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(CC c) {
		if(this.start > c.start) return 1;
		else if(this.start < c.start) return -1;
		else {
			if(this.end > c.end) return 1;
			else if(this.end < c.end) return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return start + ":" + end;
	}
	
}
/*
 * 문제의 핵심은 arraylist와 priorityqueue를 다르게 정렬하는 것
 * arraylist는 start가 end보다 먼저 검사되서 start가 작은 순으로 보고
 * priorityqueue는 end가 start보다 먼저 검사되서 end가 작은 순으로 나오게 해야 한다
 */