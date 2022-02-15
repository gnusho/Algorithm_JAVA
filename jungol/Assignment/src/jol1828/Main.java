package jol1828;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		T[] input = new T[N];
		
		for(int i = 0; i < N; i++) {
			int l = sc.nextInt();
			int h = sc.nextInt();
			
			input[i] = new T(l,h);
		}
		
		Arrays.sort(input);
		
		int cnt = 1;
		int min = -300, max = 10000;
		
		for(int i = 0; i < N; i++) {
			if(input[i].high < min || input[i].low > max) {
				cnt++;
				min = input[i].low;
				max = input[i].high;
			} else {
				min = Math.max(min, input[i].low);
				max = Math.min(max, input[i].high);
			}
		}
		
		System.out.println(cnt);
	}

}

class T implements Comparable<T>{
	int low;
	int high;
	
	T(int l, int h){
		low = l;
		high = h;
	}

	@Override
	public int compareTo(T o) {
		if(this.low < o.low) {
			return -1;
		} else if(this.low > o.low) {
			return 1;
		} else {
			if(this.high > o.high) {
				return -1;
			} else if(this.high < o.high) {
				return 1;
			} else return 0;
		}
	}
	
	@Override
	public String toString() {
		return low + " " + high + "\n";
	}
}