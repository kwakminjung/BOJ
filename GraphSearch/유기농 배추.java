/*
백준 1012번 : 유기농 배추 (실버2)
알고리즘 분류 : 그래프 이론, 그래프 탐색, 넓이 우선 탐색, 깊이 우선 탐색
풀이 : https://cuckoobird.tistory.com/203

solution 함수: BFS 함수 
결과 : 맞았습니다 (메모리 	16192KB | 시간 136ms)

dfs_stack 함수: DFS 활용 - 스택
결과 : 맞았습니다 (메모리 	16040KB | 시간 144ms)

dfs 함수: DFS 활용 - 재귀함수
결과 : 맞았습니다 (메모리 	15920KB | 시간 132ms)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, k;
	// 상 하 좌 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int[][] matrix;
	static boolean[][] visited;
	
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y =y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		
		while(t>0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n =Integer.valueOf(st.nextToken());
			m =Integer.valueOf(st.nextToken());
			k =Integer.valueOf(st.nextToken());
			
			matrix = new int[n][m];
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r=Integer.valueOf(st.nextToken());
				int c=Integer.valueOf(st.nextToken());
				
				matrix[r][c] = 1;
			}
			visited= new boolean[n][m];
			int ans=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m; j++) {
					if(!visited[i][j] && matrix[i][j] == 1) {
						// solution(i, j); // bfs 풀이
						// dfs_stack(i, j); // dfs 풀이 - stack 활용
						dfs(i, j); // dfs 풀이 - 재귀함수 활용
						ans ++;
					}
				}
			}
			System.out.println(ans);
			
			t--;
		}
	}
	
	public static void dfs_stack(int row, int col) {
		Stack<Node> s = new Stack<>();
		s.push(new Node(row, col));
		
		while(!s.isEmpty()) {
			Node cur=s.pop();
			if(visited[cur.x][cur.y]) continue;
			visited[cur.x][cur.y] = true;
			
			for(int i=0; i<4; i++) {
				int next_x = cur.x+dx[i];
				if(next_x <0 || next_x>=n) continue;
				int next_y = cur.y+dy[i];
				if(next_y<0|| next_y>=m) continue;
				
				if(!visited[next_x][next_y]&& matrix[next_x][next_y] == 1) {
					s.push(new Node(next_x, next_y));
				}
			}
		}
	}
	
	public static void dfs(int row, int col) {
		if(visited[row][col]) return;
		visited[row][col] = true;
		
		for(int i=0; i<4; i++) {
			int next_x = row+dx[i];
			if(next_x <0 || next_x>=n) continue;
			int next_y = col+dy[i];
			if(next_y<0|| next_y>=m) continue;
			
			if(!visited[next_x][next_y]&& matrix[next_x][next_y] == 1) {
				dfs(next_x, next_y);
			}
		}
	}
	
	public static void solution(int row, int col){
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col));
		
		while(!q.isEmpty()) {
			Node cur=q.poll();
			if(visited[cur.x][cur.y]) continue;
			visited[cur.x][cur.y] = true;
			
			for(int i=0; i<4; i++) {
				int next_x = cur.x+dx[i];
				if(next_x <0 || next_x>=n) continue;
				int next_y = cur.y+dy[i];
				if(next_y<0|| next_y>=m) continue;
				
				if(!visited[next_x][next_y]&& matrix[next_x][next_y] == 1) {
					q.offer(new Node(next_x, next_y));
				}
			}
		}
	}
}
