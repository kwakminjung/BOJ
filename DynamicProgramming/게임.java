/*
백준 1103번 : 게임 (골드2)
알고리즘 분류 : 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색, 깊이 우선 탐색
풀이 : https://cuckoobird.tistory.com/146
결과 : 맞았습니다 (메모리 16896KB | 시간 172ms | 코드 길이 1738B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int hole = -99;
	private static int max = -1;
	private static int n, m;
	private static int[][] graph, dp;
	private static boolean[][] visited;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	
	private static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		dp = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			String str = bf.readLine();
			for(int j = 0 ; j < m ; j++) {
				if(str.charAt(j) == 'H') {
					graph[i][j] = hole;
				} else {
					graph[i][j] = str.charAt(j) - '0';
				}
			}
		}
		
		visited[0][0] = true;
		dfs(0, 0, 1);
		
		if(flag) {
			bw.write("-1");
		} else {
			bw.write(max + "\n");
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int x, int y, int cnt) {
		if(cnt > max) {
			max = cnt;
		}
		dp[x][y] = cnt;
		for(int i = 0 ; i < 4 ; i++) {
			int move = graph[x][y];
			int nx = x + (move * dx[i]);
			int ny = y + (move * dy[i]);
			
			if(nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1 || graph[nx][ny] == hole) {
				continue;
			}
			
			if(visited[nx][ny]) {
				flag = true;
				return;
			}
			
			if(dp[nx][ny] > cnt) continue;
			
			visited[nx][ny] = true;
			dfs(nx, ny, cnt + 1);
			visited[nx][ny] = false;
		}
	}
}
