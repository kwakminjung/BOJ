/*
백준 1261번 : 알고스팟 (골드4)
알고리즘 분류 : 그래프 이론, 그래프 탐색, 데이크스트라(다익스트라), 1-0 너비 우선 탐색
풀이 : https://cuckoobird.tistory.com/111
결과 : 맞았습니다 (메모리 14684KB | 시간 152ms | 코드 길이 2006B)
*/

import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
	int x;
	int y;
	int cnt;
	
	Point(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	
	@Override
	public int compareTo(Point o) {
		return cnt - o.cnt;
	}
}

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int n;
	private static int m;
	private static int[][] map;
	private static boolean[][] visited;
	
	private static final int[] dx = {-1, 0, 1, 0};
	private static final int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		visited = new boolean[m][n];
		
		for(int i = 0 ; i < m ; i++) {
			String str = bf.readLine();
			for(int j = 0 ; j < n ; j++) {
				if(str.charAt(j) == '0') {
					map[i][j] = 0;
				} else map[i][j] = 1;
			}
		}
		
		int ans = bfs(0, 0);
		
		bw.write(Integer.toString(ans));
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	private static int bfs(int x, int y) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0, 0, 0));
		visited[x][y] = true;
		
		int nx, ny;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(p.x == m-1 && p.y == n-1) {
				return p.cnt;
			}
			for(int i = 0 ; i < 4 ; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) {
					continue;
				}
				if(!visited[nx][ny] && map[nx][ny] == 0) {
					visited[nx][ny] = true;
					queue.offer(new Point(nx, ny, p.cnt));
				}
				if(!visited[nx][ny] && map[nx][ny] == 1) {
					map[nx][ny] = 0;
					visited[nx][ny] = true;
					queue.offer(new Point(nx, ny, p.cnt + 1));
				}
			}
		}
		return 0;
	}
}
