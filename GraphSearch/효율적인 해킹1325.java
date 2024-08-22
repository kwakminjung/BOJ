/*
백준 1325번 : 효율적인 해킹 (실버1)
알고리즘 분류 : 그래프 이론, 그래프 탐색, 넓이 우선 탐색, 깊이 우선 탐색
풀이 : https://cuckoobird.tistory.com/205
결과 : 맞았습니다 (메모리 306328KB | 시간 10920ms)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] matrix;
	static int[] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		matrix=new ArrayList[n+1];
		cnt = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
		    matrix[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			matrix[a].add(b);
		}
		
		for(int i=1;i<=n;i++) {
			visited = new boolean[n+1];
			BFS(i);
		}
		
		int max=0;
		for(int i=1;i<=n;i++) {
			max = Math.max(max, cnt[i]);
		}
		
		for(int i=1;i<=n;i++) {
			if(max == cnt[i]) System.out.print(i + " ");
		}
		
	}	
	
	public static void BFS(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		visited[i] = true;
		
		while(!q.isEmpty()) {
			int curr=q.poll();
			for(int idx: matrix[curr]) {
				if(!visited[idx]) {
					visited[idx]=true;
					q.offer(idx);
					cnt[idx]++;
				}
			}
		}
	}
}
