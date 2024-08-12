package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1897 {
	static class Node {
		String w;
		int cnt;
		boolean visited;
		
		public Node(String w) {
			this.w = w;
			this.cnt = 0;
			this.visited = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int d = Integer.valueOf(st.nextToken());
		String origin = st.nextToken();
		List<Node> nodes = new ArrayList<>();
		for(int i=0; i<d; i++) {
			String w = br.readLine();
			nodes.add(new Node(w));
		}
		
		int max = solution(d, origin, nodes);
		for(int i=0; i<d; i++) {
			if(nodes.get(i).cnt == max) {
				System.out.println(nodes.get(i).w);
			}
		}
	}
	
	public static int solution(int d, String origin, List<Node> nodes) {
		int max = 0;
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(origin));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			System.out.println("------");
			// 탐색할 문자 확인 (현재 문자 +1 인 문자)
			for(int i=0; i<d; i++) {
				System.out.println(cur.w);
				if(!nodes.get(i).visited && nodes.get(i).w.length() == cur.w.length()+1) {
					int tmp=0; // cur 문자열의 인덱스
					System.out.println("current: " + nodes.get(i).w + " vs " + cur.w);
					
					// 문자의 적합성 확인 (노드 연결-큐 삽입)
					for(int j=0; j<nodes.get(i).w.length(); j++) {
						if(nodes.get(i).w.charAt(j) == cur.w.charAt(tmp)) {
							tmp ++;
						}
						if(tmp == cur.w.length()) {
							q.add(nodes.get(i));
							nodes.get(i).cnt = cur.cnt + 1;
							max = nodes.get(i).cnt > max ? nodes.get(i).cnt : max;
							nodes.get(i).visited = true;
							break;
						}
					}
					
				}
			}
		}
		
		return max;
	}
}
