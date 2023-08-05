/*
백준 1647번 : 도시 분할 계획 (골드4)
알고리즘 분류 : 그래프 이론, 최소 스패닝 트리
풀이 : https://cuckoobird.tistory.com/124
결과 : 맞았습니다 (메모리 320952KB | 시간 1220ms | 코드 길이 1725B)
메모 : 
후에 다시 시도
*/

import java.io.*;
import java.util.*;

public class Main {
	public static class Node implements Comparable<Node>{
		int s;
		int e;
		int cost;
		
		public Node(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node n1) {
			return this.cost - n1.cost;
		}
	}
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int n, m;
	private static PriorityQueue<Node> q;
	private static int[] parent;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		q = new PriorityQueue<>();
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			q.offer(new Node(s, e, cost));
		}
		
		parent = new int[n + 1];
		bw.write(kruscal() + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	public static int kruscal() {
		for(int i = 1 ; i <= n ; i++) {
			parent[i] = i;
		}
		
		int count = 0;
		int dist = 0;
		while(count < n - 2) {
			Node node = q.poll();
			int p1 = find(node.s);
			int p2 = find(node.e);
			
			if(p1 != p2) {
				union(p1, p2);
				dist += node.cost;
				count ++;
			}
		}
		return dist;
	}
	
	public static void union(int a, int b) {
		parent[a] = b;
	}
	
	public static int find(int a) {
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
}
