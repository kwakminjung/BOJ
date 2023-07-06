/*
백준 16562번 : 친구비 (골드4)
알고리즘 분류 : 자료 구조, 그래프 이론, 그래프 탐색, 분리 집합
풀이 : https://cuckoobird.tistory.com/98
결과 : 맞았습니다 (메모리 564508KB | 시간 1000ms | 코드 길이 2304B)
메모 :
bfs, dfs로 푼 코드
분리 집합은 다음에 쉬운 문제로 도전해보기
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int[] friends;
	private static boolean[] visited;
	private static int min;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int K = k;
		
		int[][] node = new int[n][n];
		
		StringTokenizer st_k = new StringTokenizer(bf.readLine());
		friends = new int[n];
		for(int i = 0 ; i < n ; i++) {
			friends[i] = Integer.parseInt(st_k.nextToken());
		}
		
		for(int i = 0 ; i < m ; i++) {
			StringTokenizer st_c = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st_c.nextToken()) - 1;
			int y = Integer.parseInt(st_c.nextToken()) - 1;
			node[x][y] = 1;
			node[y][x] = 1;
		}
		
		visited = new boolean[n];
		
		PriorityQueue<Integer> graph = new PriorityQueue<>();
//		Stack<Integer> graph = new Stack<>();
		boolean flag = true;
		
		for(int i = 0 ; i < n ; i++) {
			if(!visited[i]) {
				min = 10000000;
				bfs(graph, node, i);
//				dfs(graph, node, i);
				k -= min;
			}
			if(k < 0) {
				flag = false;
				break;
			}
		}
		if(!flag) {
			bw.write("Oh no");
		} else {
			bw.write(Integer.toString(K - k));
		}
		
		bf.close();
		bw.flush();
		bw.close();	
	}
	private static void bfs(PriorityQueue<Integer> graph, int[][] node, int n) {
		visited[n] = true;
		min = Math.min(friends[n], min);
		graph.poll();
		for(int i = 0 ; i < node.length ; i++) {
			if(!visited[i] && node[n][i] == 1) {
				graph.add(i);
				bfs(graph, node, i);
			}
		}
	}
	
	private static void dfs(Stack<Integer> graph, int[][] node, int n) {
		visited[n] = true;
		min = Math.min(friends[n], min);
		graph.push(n);
		for(int i = 0 ; i < node.length ; i++) {
			if(!visited[i] && node[n][i] == 1) {
				dfs(graph, node, i);
			} else if(visited[i] && node[n][i] == 1 && graph.size() > 0) {
				graph.pop();
			}
		}
	}
}
