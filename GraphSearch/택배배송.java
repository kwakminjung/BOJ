/*
백준 5972번 : 택배 배송 (골드5)
알고리즘 분류 : 그래프 이론, 데이크스트라
풀이 : https://cuckoobird.tistory.com/128
결과 : 맞았습니다 (메모리 40936KB | 시간 496ms | 코드 길이 1903B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int n, m;
	private static int[] dist;
	private static ArrayList<Node>[] graph;
	private static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dist = new int[n + 1];
		Arrays.fill(dist, INF);
		
		graph = new ArrayList[n + 1];
		for(int i = 1 ; i <= n ; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[x].add(new Node(y, v));
			graph[y].add(new Node(x, v));
		}
		
		dijkstra(1);
		
		bw.write(dist[n] + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> Q = new PriorityQueue<>();
		dist[start] = 0;
		Q.add(new Node(start, 0));
		
		while(!Q.isEmpty()) {
			Node curr = Q.poll();
			
			if(curr.distance > dist[curr.index]) continue;
			
			for(Node next : graph[curr.index]) {
				if(dist[next.index] > curr.distance + next.distance) {
					dist[next.index] = curr.distance + next.distance;
					Q.add(new Node(next.index, dist[next.index]));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node> {
		int index;
		int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
}
