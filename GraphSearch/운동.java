/*
백준 1956번 : 운동 (골드4)
알고리즘 분류 : 그래프 이론, 플로이드-워셜
풀이 : https://cuckoobird.tistory.com/106
결과 : 맞았습니다 (메모리 60196KB | 시간 772ms | 코드 길이 1334B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int INF = 9900001;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int[][] node = new int[v][v];
		
		for(int i = 0 ; i < v ; i++) {
			for(int j = 0 ; j < v ; j++) {
				node[i][j] = INF;
			}
		}
		
		for(int i = 0 ; i < e ; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			
			node[a][b] = c;
		}
		
		for(int k = 0 ; k < v ; k++) {
			for(int i = 0 ; i < v ; i++) {
				for(int j = 0 ; j < v ; j++) {
					if(node[i][j] > node[i][k] + node[k][j]) {
						node[i][j] = node[i][k] + node[k][j];
					}
				}
			}
		}
		
		int ans = INF;
		for(int i = 0 ; i < v ; i++) {
			ans = Math.min(ans, node[i][i]);
		}
		
		if(ans == INF) bw.write("-1");
		else bw.write(Integer.toString(ans));
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
