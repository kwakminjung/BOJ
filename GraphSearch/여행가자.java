/*
백준 1976번 : 여행 가자 (골드4)
알고리즘 분류 : 자료 구조, 그래프 이론, 그래프 탐색, 분리 집합
풀이 : https://cuckoobird.tistory.com/125
결과 : 맞았습니다 (메모리 17840KB | 시간 196ms | 코드 길이 1390B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int[] parent;
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		
		parent = new int[n];
		for(int i = 0 ; i < n ; i++) {
			parent[i] = i;
		}
		
		StringTokenizer st;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0 ; j < n ; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) union_root(i, j);
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		int start = find_root(Integer.parseInt(st.nextToken()) - 1);
		for(int i = 0 ; i < m - 1 ; i++) {
			int now = Integer.parseInt(st.nextToken()) - 1;
			if(start != find_root(now)) {
				bw.write("NO");
				
				bf.close();
				bw.flush();
				bw.close();
				return;
			}
		}
		
		bw.write("YES");
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	private static int find_root(int x) {
		if(x == parent[x]) return x;
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
