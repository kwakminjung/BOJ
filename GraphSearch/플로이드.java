/*
백준 11404번 : 플로이드 (골드4)
알고리즘 분류 : 그래프 이론, 플로이드-워셜
풀이 : https://cuckoobird.tistory.com/101
결과 : 맞았습니다 (메모리 45304KB | 시간 492ms | 코드 길이 1927B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static final int INF = 9900001;
	
	private static boolean[] visited;
	private static int[] dist;
	private static int[][] node;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		node = new int[n][n];
		
		for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                node[i][j] = INF;

                if(i == j){
                    node[i][j] = 0;
                }
            }
        }
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken());
			
			if(node[x][y] > 0) {
				node[x][y] = Math.min(node[x][y], v);				
			} else {
				node[x][y] = v;
			}
		}
		
		floydWarshall(n);
		
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (node[i][j] == INF) {
                    node[i][j] = 0;
                }
                bw.write(node[i][j] + " ");
            }
            bw.write("\n");
        }
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	static void floydWarshall(int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (node[i][j] > node[i][k] + node[k][j]) {
                        node[i][j] = node[i][k] + node[k][j];
                    }
                }
            }
        }
    }
}
