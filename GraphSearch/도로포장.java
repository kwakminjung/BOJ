/*
백준 1162번 : 도로포장 (골드1)
알고리즘 분류 : 다이나믹 프로그래밍, 그래프 이론, 데이크스트라
풀이 : https://cuckoobird.tistory.com/144
결과 : 메모리 초과 (코드 길이 2333B)
메모 :
후에 다시 도전 (왜 메모리 초과가 나는지 모르겠음..)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int n, m, k;
	
	
	public static class Node {
		int idx;
		long distance;
		int cnt;
		
		public Node(int idx, long distance, int cnt) {
			this.idx = idx;
			this.distance = distance;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for(int i = 0 ; i <= n ; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(new Node(y, v, 0));
			graph.get(y).add(new Node(x, y, 0));
		}
		
		bw.write(dijkstra(1, graph) + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	public static long dijkstra(int start, ArrayList<ArrayList<Node>> graph) {
		long[][] distance = new long[n + 1][k + 1];
		for(int i = 0 ; i <= n ; i++) {
			Arrays.fill(distance[i], Long.MAX_VALUE);
		}
		
		PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(o -> o.distance));
		distance[start][0] = 0;
		q.add(new Node(start, 0, 0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			if(curr.distance > distance[curr.idx][curr.cnt]) continue;
			
			for(Node next : graph.get(curr.idx)) {
				if(curr.cnt < k && distance[next.idx][curr.cnt + 1] > distance[curr.idx][curr.cnt]) {
					distance[next.idx][curr.cnt + 1] = distance[curr.idx][curr.cnt];
					q.add(new Node(next.idx, distance[next.idx][curr.cnt + 1], curr.cnt + 1));
				}
				
				if(distance[next.idx][curr.cnt] > distance[curr.idx][curr.cnt] + next.distance) {
					distance[next.idx][curr.cnt] = distance[curr.idx][curr.cnt] + next.distance;
					q.add(new Node(next.idx, distance[next.idx][curr.cnt], curr.cnt));
				}
			}
		}
		
		return Arrays.stream(distance[n]).min().getAsLong();
	}
}
