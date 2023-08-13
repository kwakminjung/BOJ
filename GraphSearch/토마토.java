/*
백준 7569번 : 토마토 (골드5)
알고리즘 분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
풀이 : https://cuckoobird.tistory.com/132
결과 : 맞았습니다 (메모리 119792KB | 시간 712ms | 코드 길이 2011B)
*/

import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int x;
		int y;
		int z;
		
		Node(int z, int x, int y){
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}
	
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int m, n, h;
	private static int[][][] box;
	private static Queue<Node> Q;
	
	private static int[] dx = {-1, 0, 1, 0, 0, 0};
	private static int[] dy = {0, 1, 0, -1, 0, 0};
	private static int[] dz = {0, 0, 0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		box = new int[h][n][m];
		Q = new LinkedList<Node>();
		
		for(int i = 0 ; i < h ; i++) {
			for(int j = 0 ; j < n ; j++) {
				st = new StringTokenizer(bf.readLine());
				for(int k = 0 ; k < m ; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 1) Q.offer(new Node(i, j, k));
				}
			}
		}
		
		bw.write(BFS() + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	public static int BFS() {
		while(!Q.isEmpty()) {
			Node t = Q.poll();
			
			int z = t.z;
			int x = t.x;
			int y = t.y;
			
			for(int i = 0 ; i < 6 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				
				if(nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m  && nz < h) {
					if(box[nz][nx][ny] == 0) {
						Q.offer(new Node(nz, nx, ny));
						box[nz][nx][ny] = box[z][x][y] + 1;
					}
				}
			}
		}
		
		int result = 0;
		
		for(int i = 0 ; i < h ; i++) {
			for(int j = 0 ; j < n ; j++) {
				for(int k = 0 ; k < m ; k++) {
					if(box[i][j][k] == 0) return -1;
					result = Math.max(result, box[i][j][k]);
				}
			}
		}
		
		if(result == 1) return 0;
		else return result - 1;
	}
}
