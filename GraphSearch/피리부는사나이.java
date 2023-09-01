/*
백준 16724번 : 피리 부는 사나이 (골드3)
알고리즘 분류 : 자료 구조, 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 분리 집합
풀이 : https://cuckoobird.tistory.com/151
결과 : 맞았습니다 (메모리 28096KB | 시간 408ms | 코드 길이 1590B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int n, m;
	private static int[][] map;
	private static int[][] group;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		group = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			String str = bf.readLine();
			for(int j = 0 ; j < m ; j++) {
				char c = str.charAt(j);
				if(c == 'U') map[i][j] = 0;
				else if(c == 'D') map[i][j] = 1;
				else if(c == 'L') map[i][j] = 2;
				else map[i][j] = 3;
				
				group[i][j] = -1;
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(group[i][j] == -1) {
                	// 현재 노드에 해당하는 숫자로 루트 초기화
					group[i][j] = i * m + j;
					dfs(i, j);
				}
			}
		}
		
		bw.write(cnt + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int x, int y) {
		int nx = x + dx[map[x][y]];
		int ny = y + dy[map[x][y]];
		if(nx < 0 || ny < 0 || nx >= n || ny >= m) return;
        
        // 아직 방문하지 않은 곳
		if(group[nx][ny] == -1) {
        	// 현재 그룹의 루트 노드를 다음 노드에 넣어 루트를 나타냄
			group[nx][ny] = group[x][y];
			dfs(nx, ny);
		} else {
        	// 이때 group[x][y]에 루트값이 있음, 현재 탐색하려는 노드와 다음 노드의 루트가 같음
			if(group[x][y] == group[nx][ny]) {
				cnt ++;
				return;
			}
            // 다음노드를 보니 루트가 존재함 (이때는 group[x][y] 에 루트값이 존재하지 않음)
			group[x][y] = group[nx][ny];
		}
	}
}
