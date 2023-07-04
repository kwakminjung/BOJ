/*
백준 1743번 : 음식물 피하기 (실버1)
알고리즘 분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
풀이 : https://cuckoobird.tistory.com/95

결과 : 맞았습니다 (메모리 123528KB | 시간 580ms | 코드 길이 1949B)

메모 :
bfs 방식으로 푼 코드 (23-07-03)
dfs 방식으로도 풀어보기
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int k;
	private static boolean[] visited = new boolean[k];
	private static int[][] trash = new int[k][2];
	private static int[][] trash_node = new int[k][k];
	
	private static int cnt;
	
	private static PriorityQueue<Integer> graph = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		trash = new int[k][2];
		trash_node = new int[k][k];
		visited = new boolean[k];
		
		for(int i = 0 ; i < k ; i++) {
			StringTokenizer st_trash = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st_trash.nextToken());
			int y = Integer.parseInt(st_trash.nextToken());
			trash[i][0] = x;
			trash[i][1] = y;
			for(int j = 0 ; j < i ; j++) {
				if(Math.abs(trash[j][0] - trash[i][0]) == 1 && trash[j][1] - trash[i][1] == 0) {
					trash_node[i][j] = 1;
					trash_node[j][i] = 1;
				} else if(Math.abs(trash[j][1] - trash[i][1]) == 1 && trash[j][0] - trash[i][0] == 0) {
					trash_node[i][j] = 1;
					trash_node[j][i] = 1;
				}
			}
		}
		cnt = 0;
		
		int max = 0;
		//시작 노드를 정하는 for문
		for(int i = 0 ; i < k ; i++) {
			cnt = 0;
			if(!visited[i]) {
				bfs(i);
				if(max <= cnt) {
					max = cnt;
				}
			}
		}
		
		bw.write(Integer.toString(max));
		
		bw.flush();
		bf.close();
		bw.close();
	}
	
	private static void bfs(int node) {
		visited[node] = true;
		graph.remove(node);
		cnt ++;
		for(int i = 0 ; i < k ; i++) {
			if(!visited[i] && trash_node[node][i] == 1) {
				graph.add(i);
				bfs(i);
			}
		}
	}
}
