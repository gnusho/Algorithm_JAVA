package A27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static List<Integer> list = new ArrayList<Integer>();
	static List<Integer> total = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			list.clear();
			total.clear();
			int F = Integer.parseInt(br.readLine());
			
			int people = 0; // 입력된 사람 수
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			while(F-- > 0) {
				String[] input = br.readLine().split(" ");
				
				// input[i]에 해당하는게 map에 있는가? 없으면 만든다
				for(int i = 0; i < 2; i++) {
					if(!map.containsKey(input[i])) {
						map.put(input[i], people++);
						list.add(people - 1);
						total.add(1);
					}
				}
				
				int a = map.get(input[0]);
				int b = map.get(input[1]);
				
				merge(a,b);
				a = find(a);
				
				System.out.println(total.get(a));
			}
		}
	}
	
	public static int find(int a) {
		if(list.get(a) == a) return a;
		list.set(a, find(list.get(a)));
		return list.get(a);
	}
	
	public static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		//System.out.println(a + " " + b);
		if(b < a) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		if(a == b) return; // 값이 같을 때를 처리를 안해줘서 계속 틀렸다
		list.set(b, a);
		total.set(a, total.get(a) + total.get(b));
	}

}

// unionfind 문제 
// 근데 index 대신에 이름을 주니까 Map을 사용해서 이름과 index를 매칭 시키면 됨
// 더욱이 사람 수를 모름 물론 F * 2를 해도 되지만 그냥 ArrayList를 사용해서 구현할 예정
// rank를 통해서 시간복잡도를 줄여야할 것 같음 -> 그래도 시간초과 남
// root가 같은지 하나씩 검사하면 시간초과가 남 -> 생각해보면 십만 * 십만이니까 당연히 날만함
// 그렇다면 rank를 사용하듯이 total이란 것을 만들어서 관리해볼까
// 합칠 때에 rank가 큰 거에다가 rank가 작은거의 total값을 더하면 되지 않을까? -> 이번엔 답이 틀림