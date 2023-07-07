/*
백준 24391번 : 귀찮은 해강이 (골드5)
알고리즘 분류 : 자료 구조, 그래프 이론, 그래프 탐색, 분리 집합
풀이 : https://cuckoobird.tistory.com/99
결과 : 맞았습니다 (메모리 51140KB | 시간 464ms | 코드 길이 1485B)
메모 :
union_root 함수 최적화 방법 이해해보기
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
		
		parent = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			parent[i] = i;
		}
		
		for(int i = 0 ; i < m ; i++) {
			StringTokenizer st_node = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st_node.nextToken()) - 1;
			int y = Integer.parseInt(st_node.nextToken()) - 1;
			union_root(x, y);
		}
		
		StringTokenizer st_order = new StringTokenizer(bf.readLine());
		int[] order = new int[n];
		for(int i = 0 ; i < n ; i++) {
			order[i] = Integer.parseInt(st_order.nextToken()) - 1;
		}
		
		int cnt = 0;
		for(int i = 0 ; i < n-1 ; i++) {
			if(find_root(order[i]) != find_root(order[i + 1])) {
				cnt ++;
			}
		}
		
		bw.write(Integer.toString(cnt));
		
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
