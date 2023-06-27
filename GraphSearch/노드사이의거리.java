/*
백준 1240번 : 노드 사이의 거리 (골드5)
알고리즘 분류 : 그래프 이론, 그래프 탐색, 트리, 너비 우선 탐색, 깊이 우선 탐색
풀이 : https://cuckoobird.tistory.com/88#comment19082878
: 다익스트라 알고리즘 사용

결과 : 시간초과 (코드 길이 : 2207B)

추후에 시간초과 해결해보기
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
	static int[][] matrix;
	static int N, M;
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] NM = new String[2];
		
		NM = bf.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		matrix = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(i == j) {
					matrix[i][j] = 0;
				}
				else {
					matrix[i][j] = 100001;					
				}
			}
		}
		
		int row, col;
		int value;
		
		String[] nodeArr = new String[3];
		
		for(int i = 0 ; i < (N-1) ; i++) {
			nodeArr = bf.readLine().split(" ");

			row = Integer.parseInt(nodeArr[0]) - 1;
			col = Integer.parseInt(nodeArr[1]) - 1;
			value = Integer.parseInt(nodeArr[2]);
			matrix[row][col] = value;
			matrix[col][row] = value;
		}
		
		String[] QArr = new String[2];
		int node1, node2;
		int[] ans = new int[M];
		
		for(int i = 0 ; i < M ; i++) {
			visited = new boolean[N];
			dist = new int[N];
			for(int j = 0 ; j < N ; j++) {
				dist[j] = 100001;
			}
			
			QArr = bf.readLine().split(" ");
			node1 = Integer.parseInt(QArr[0]) - 1;
			node2 = Integer.parseInt(QArr[1]) - 1;
			
			int pre = node1;
			
			dist[pre] = 0;
			
			while(true) {
				if(pre == node2) {
					break;
				}
				pre = dijktra(pre);
				if(pre == -1 && pre != node2) {
					pre = node1;
				}
			}
			
			ans[i] = dist[node2];
		}
		for(int i = 0 ; i < M ; i++) {
			bw.write(Integer.toString(ans[i]) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	
	public static int dijktra(int pre) {
		int min = 100001;
		int next = -1;
		visited[pre] = true;
		for(int i = 0 ; i < N ; i++) {
			if(!visited[i] && dist[i] >= matrix[pre][i] + dist[pre]) {
				dist[i] = matrix[pre][i] + dist[pre];
				if(min >= dist[i] && !visited[i]) {
					min = dist[i];
					next = i;
				}
			}
		}
		return next;
	}
}
