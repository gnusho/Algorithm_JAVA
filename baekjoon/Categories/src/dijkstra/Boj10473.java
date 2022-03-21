package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Boj10473 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<double[]> arr = new ArrayList<>();
		String[] input = br.readLine().split(" ");
		arr.add(new double[] {Double.parseDouble(input[0]),Double.parseDouble(input[1])});
		input = br.readLine().split(" ");
		arr.add(new double[] {Double.parseDouble(input[0]),Double.parseDouble(input[1])});
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			arr.add(new double[] {Double.parseDouble(input[0]),Double.parseDouble(input[1])});
		}
		
		double[] distArr = new double[N + 2];
		Arrays.fill(distArr, Double.MAX_VALUE);
		boolean[] visit = new boolean[N + 2];
		// 결과적으로 distArr[1]값을 만들면 되는 문제
		
		PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2)->{
			if(n1.dist > n2.dist) return 1;
			else if(n1.dist < n2.dist) return -1;
			else return 0;
		});
		distArr[0] = 0;
		//Math.round(pie*1000)/1000.0
		for(int i = 1; i < N + 2; i++) {
			double walkDistance =  Math.sqrt(Math.pow(arr.get(0)[0] - arr.get(i)[0], 2) + Math.pow(arr.get(0)[1] - arr.get(i)[1], 2));
			pq.add(new Node((double)Math.round(walkDistance*20000)/100000,i));
			distArr[i] = (double)Math.round(walkDistance*20000)/100000;
		}
		//pq.add(new Node(0, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visit[now.index]) continue;
			visit[now.index] = true;
			
			for(int i = 1; i < N + 2; i++) {
				if(visit[i]) continue;
				double wholeDistance = Math.sqrt(Math.pow(arr.get(now.index)[0] - arr.get(i)[0], 2) + Math.pow(arr.get(now.index)[1] - arr.get(i)[1], 2));
				double walkDistance = Math.abs(wholeDistance - 50) < wholeDistance ? Math.abs(wholeDistance - 50):wholeDistance;
				
				if(distArr[i] >  distArr[now.index] + (double)Math.round(walkDistance*20000)/100000 + 2) {
					distArr[i] = distArr[now.index] + (double)Math.round(walkDistance*20000)/100000 + 2;
					pq.offer(new Node(distArr[i], i));
					//System.out.println(now.index + " " + i + " " + distArr[i]);
				}
				
			}
		}
		
		System.out.println((double)Math.round(distArr[1]*100000) / 100000);
	}
	
	static class Node{
		double dist;
		int index;
		
		Node(double dist, int index){
			this.dist = dist;
			this.index = index;
		}
	}
}
