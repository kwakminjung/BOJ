/*
백준 5107번 : 마니또 (실버1)
알고리즘 분류 : 자료 구조, 그래프 이론, 그래프 탐색, 해시를 사용한 집합과 맵, 순열 사이클 분할
풀이 : https://cuckoobird.tistory.com/110
결과 : 맞았습니다 (메모리 16080KB | 시간 148ms | 코드 길이 1517B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static boolean[] visited;
	private static int cnt;
	
	public static void main(String[] args) throws IOException {
		int t = 0;
		while(true) {
			int n = Integer.parseInt(bf.readLine());
			if(n == 0) {
				break;
			} else {
				t ++;
				cnt = 0;
				int[][] node = new int[n][n];
				ArrayList<String> name = new ArrayList<>();
				
				for(int i = 0 ; i < n ; i++) {
					StringTokenizer st = new StringTokenizer(bf.readLine());
					String x = st.nextToken();
					String y = st.nextToken();
					if(!name.contains(x)) name.add(x);
					if(!name.contains(y)) name.add(y);
					
					node[name.indexOf(x)][name.indexOf(y)] = 1;
				}
				
				PriorityQueue<Integer> graph = new PriorityQueue<>();
				visited = new boolean[n];
				for(int i = 0 ; i < n ; i++) {
					if(!visited[i]) {
						bfs(graph, node, i);
					}
				}
				
				bw.write(Integer.toString(t) + " " + Integer.toString(cnt) + "\n");
			}
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	private static void bfs(PriorityQueue<Integer> graph, int[][] node, int n) {
		visited[n] = true;
		graph.poll();
		for(int i = 0 ; i < node.length ; i++) {
			if(node[n][i] == 1) {
				if(!visited[i]) {
					graph.add(i);
					bfs(graph, node, i);					
				} else cnt ++;
			}
		}
	}
}
