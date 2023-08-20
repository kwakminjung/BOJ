/*
백준 4195번 : 친구 네트워크 (골드2)
알고리즘 분류 : 자료 구조, 해시를 사용한 집합과 맵, 분리 집합
풀이 : https://cuckoobird.tistory.com/139
결과 : 맞았습니다 (메모리 70292KB | 시간 1288ms | 코드 길이 1411B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int[] parent;
	private static int[] level;
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(bf.readLine());
		
		while(t > 0) {
			t--;
			
			int n = Integer.parseInt(bf.readLine());
			parent = new int[n * 2];
			level = new int[n * 2];
			for(int i = 0 ; i < n * 2 ; i++) {
				parent[i] = i;
				level[i] = 1;
			}
			
			int idx = 0;
			Map<String, Integer> map = new HashMap<>();
			
			for(int i = 0 ; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				if(!map.containsKey(a)) {
					map.put(a, idx++);
				}
				if(!map.containsKey(b)) {
					map.put(b, idx++);
				}
				bw.write(union_root(map.get(a), map.get(b)) + "\n");
			}
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	private static int find_root(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find_root(parent[x]);
	}
	
	private static int union_root(int x, int y) {
		x = find_root(x);
		y = find_root(y);
		
		if(x != y) {
			parent[x] = y;
			level[y] += level[x];
			level[x] = 1;
		}
		return level[y];
	}
}
