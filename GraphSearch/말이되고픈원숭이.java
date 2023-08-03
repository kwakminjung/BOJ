/*
백준 1600번 : 말이 되고픈 원숭이 (골드3)
알고리즘 분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
풀이 : https://cuckoobird.tistory.com/122
결과 : 맞았습니다 (메모리 91428KB | 시간 580ms | 코드 길이 2366B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int k, w, h;
	private static int[][] map;
	
	private static int min = Integer.MAX_VALUE;
	private static int[] hdx = {-2, -1, -2, -1, 1, 2, 1, 2};
	private static int[] hdy = {-1, -2, 1, 2, -2, -1, 2, 1};
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static boolean[][][] visited;
	
	private static Queue<Node> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		k = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		
		for(int i = 0 ; i < h ; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0 ; j < w ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[h][w][k + 1];
		min = BFS(0, 0);
		
		if(min == Integer.MAX_VALUE) bw.write("-1");
		else bw.write(min + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	public static int BFS(int x, int y) {
		q.offer(new Node(x, y, 0, k));
		visited[x][y][k] = true;
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			if(current.x == h - 1 && current.y == w - 1) return current.cnt;
			
			for(int i = 0 ; i < 4 ; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny][current.k] && map[nx][ny] == 0) {
					visited[nx][ny][current.k] = true;
					q.offer(new Node(nx, ny, current.cnt + 1, current.k));
				}
			}
			
			if(current.k > 0) {
				for(int i = 0 ; i < 8 ; i++) {
					int nx = current.x + hdx[i];
					int ny = current.y + hdy[i];
					if(nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny][current.k - 1] && map[nx][ny] == 0) {
						visited[nx][ny][current.k - 1] = true;
						q.offer(new Node(nx, ny, current.cnt + 1, current.k - 1));
					}
				}
			}
		}
		return min;
	}
	
	static class Node {
		int x, y, cnt, k;
		
		public Node(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}
}
