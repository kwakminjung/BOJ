/*
백준 1303번 : 전쟁 - 전투 (실버1)
알고리즘 분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
풀이 : https://cuckoobird.tistory.com/96

결과 : 맞았습니다 (메모리 212488KB | 시간 588ms | 코드 길이 3180B)

메모 :
bfs와 dfs 를 이용한 코드 (주석)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int cnt = 0;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> w_soldier = new ArrayList<>();
		ArrayList<int[]> b_soldier = new ArrayList<>();
		
		for(int i = 0 ; i < m ; i++) {
			String team = bf.readLine();
			for(int j = 0 ; j < n ; j++) {
				if('W' == team.charAt(j)) {
					int[] w = new int[2];
					w[0] = i;
					w[1] = j;
					w_soldier.add(w);
				} else {
					int[] b = new int[2];
					b[0] = i;
					b[1] = j;
					b_soldier.add(b);
				}
			}
		}
		
		int[][] w_node = draw_connection(w_soldier.size(), w_soldier);
		int[][] b_node = draw_connection(b_soldier.size(), b_soldier);
		
		// bfs 함수 사용 시 큐
		//PriorityQueue<Integer> w_graph = new PriorityQueue<>();
		//PriorityQueue<Integer> b_graph = new PriorityQueue<>();
		
		// dfs 함수 사용 시 스택
		Stack<Integer> w_graph = new Stack<>();
		Stack<Integer> b_graph = new Stack<>();
		
		visited = new boolean[w_soldier.size()];
		int w_sum = 0;
		for(int i = 0 ; i < w_soldier.size() ; i++) {
			cnt = 0;
			if(!visited[i]) {
//				bfs(w_graph, w_node, i);
				dfs(w_graph, w_node, i);
				w_sum += Math.pow(cnt, 2);
			}
		}
		
		visited = new boolean[b_soldier.size()];
		int b_sum = 0;
		for(int i = 0 ; i < b_soldier.size() ; i++) {
			cnt = 0;
			if(!visited[i]) {
//				bfs(b_graph, b_node, i);
				dfs(b_graph, b_node, i);
				b_sum += Math.pow(cnt, 2);
			}
		}
		
		bw.write(Integer.toString(w_sum));
		bw.write("\n");
		bw.write(Integer.toString(b_sum));
		
		bw.flush();
		bf.close();
		bw.close();
		
	}
	
	private static int[][] draw_connection(int size, ArrayList<int[]> arr) {
		int[][] path = new int[size][size];
		
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0 ; j < i ; j++) {
				if(Math.abs(arr.get(j)[0] - arr.get(i)[0]) == 1 && arr.get(j)[1] - arr.get(i)[1] == 0) {
					path[i][j] = 1;
					path[j][i] = 1;
				} else if(Math.abs(arr.get(j)[1] - arr.get(i)[1]) == 1 && arr.get(j)[0] - arr.get(i)[0] == 0) {
					path[i][j] = 1;
					path[j][i] = 1;
				}
			}
		}
		
		return path;
	}
	
	private static void bfs(PriorityQueue<Integer> graph, int[][] soldier_node, int node) {
		visited[node] = true;
		graph.poll();
		cnt++;
		for(int i = 0 ; i < soldier_node.length ; i++) {
			if(!visited[i] && soldier_node[node][i] == 1) {
				graph.add(i);
				bfs(graph, soldier_node, i);
			}
		}
	}
	
	private static void dfs(Stack<Integer> graph, int[][] soldier_node, int node) {
		visited[node] = true;
		graph.push(node);
		cnt++;
		for(int i = 0 ; i < soldier_node.length ; i++) {
			if(!visited[i] && soldier_node[node][i] == 1) {
				dfs(graph, soldier_node, i);
			} else if(visited[i] && soldier_node[node][i] == 1 && graph.size() > 0) {
				graph.pop();
			}
		}
	}
}
