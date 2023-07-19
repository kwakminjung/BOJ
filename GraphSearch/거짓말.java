/*
백준 1043번 : 거짓말 (골드4)
알고리즘 분류 : 자료 구조, 그래프 이론, 그래프 탐색, 분리 집합
풀이 : https://cuckoobird.tistory.com/109
결과 : 맞았습니다 (메모리 14360KB | 시간 136ms | 코드 길이 1733B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int[] parent;
	
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] truth = new int[n];
		
		parent = new int[n];
		for(int i = 0 ; i < n ; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(bf.readLine());
		int k = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < k ; i++) {
			int t = Integer.parseInt(st.nextToken()) - 1;
			truth[t] = 1;
		}
		
		int[][] party = new int[m][50];
		int[] p = new int[m];
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(bf.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < p[i] ; j++) {
				int v = Integer.parseInt(st.nextToken()) - 1;
				party[i][j] = v;
				if(j > 0) union_root(party[i][j - 1], party[i][j]);
			}
		}
		
		int ans = m;
		for(int i = 0 ; i < n ; i++) {
			if(truth[i] == 1) {
				truth[find_root(i)] = 1;
			}
		}
		
		int a = 0;
		for(int i = 0 ; i < m ; i++) {
			a = find_root(party[i][0]);
			if(truth[a] == 1) ans --;
		}
		
		bw.write(Integer.toString(ans));
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	private static int find_root(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find_root(parent[x]);
	}
	
	private static void union_root(int x, int y) {
		x = find_root(x);
		y = find_root(y);
		
		if(x != y) {
			parent[x] = y;
		}
	}
}
