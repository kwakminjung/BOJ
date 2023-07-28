/*
백준 1937번 : 욕심쟁이 판다 (골드3)
알고리즘 분류 : 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색, 깊이 우선 탐색
풀이 : https://cuckoobird.tistory.com/117
결과 : 맞았습니다 (메모리 37600KB | 시간 516ms | 코드 길이 1516B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int[][] node;
	private static int[][] dp;
	private static int n;
	
	private static int[] rangeX = {-1, 1, 0, 0};
	private static int[] rangeY = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(bf.readLine());
		node = new int[n][n];
		dp = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());			
			for(int j = 0 ; j < n ; j++) {
				node[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				ans = Math.max(ans, dfs(i, j));
			}
		}
		
		bw.write(Integer.toString(ans));
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	public static int dfs(int x, int y) {
		if(dp[x][y] != 0) {
			return dp[x][y];
		}
		
		dp[x][y] = 1;
		
		int dx, dy;
		for(int i = 0; i < 4; i++) {
			dx = x + rangeX[i];
			dy = y + rangeY[i];
			
			if(dx < 0 || dy < 0 || dx > n-1 || dy > n-1) {
				continue;
			}
			
			if(node[x][y] < node[dx][dy]) {
				dp[x][y] = Math.max(dp[x][y], dfs(dx, dy) + 1);
				dfs(dx, dy);
			}
		}
		return dp[x][y];
	}
}
