/*
백준 1355번 : 구멍난 케이크 자르기 (골드2)
알고리즘 분류 : 수학, 구현, 그래프 이론, 그래프 탐색, 깊이 우선 탐색
풀이 : https://cuckoobird.tistory.com/148
결과 : 맞았습니다 (메모리 29200KB | 시간 592ms | 코드 길이 1931B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int lc, lh, h, v;
	private static int[][] cake;

	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		lc = Integer.parseInt(st.nextToken());
		lh = Integer.parseInt(st.nextToken());
		
		cake = new int[lc * 4][lc * 4];
		for(int i = 0 ; i < 4 * lc ; i++) {
			Arrays.fill(cake[i], 1);			
		}
		for(int i = 2 * (lc - lh) ; i < 2 * (lc + lh) ; i++) {
			for(int j = 2 * (lc - lh) ; j < 2 * (lc + lh) ; j++) {
				cake[i][j] = 0;
			}
		}
		
		h = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i = 0 ; i < h ; i++) {
			int y = Integer.parseInt(st.nextToken());
			y = 2 * (lc - y);
			for(int j = 0 ; j < 4 * lc ; j++) {
				cake[y][j] = 0;
			}
		}
		
		v = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i = 0 ; i < v ; i++) {
			int x = Integer.parseInt(st.nextToken());
			x = 2 * (lc - x);
			for(int j = 0 ; j < 4 * lc ; j++) {
				cake[j][x] = 0;
			}
		}
		
		int ans = 0;
		for(int i = 0 ; i < 4 * lc ; i++) {
			for(int j = 0 ; j < 4 * lc ; j++) {
				if(cake[i][j] == 1) {
					ans ++;
					dfs(i, j);
				}
			}
		}
		
		bw.write(ans + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int r, int c) {
		if(r < 0 || c < 0 || r >= 4 * lc || c >= 4 * lc) return;
		
		cake[r][c] = 0;
		for(int i = 0 ; i < 4 ; i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			if(nx < 0 || ny < 0 || nx >= 4 * lc || ny >= 4 * lc) continue;
			if(cake[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
}
