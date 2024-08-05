/*
백준 1276번 : PLATFORME (실버1)
알고리즘 분류 : 구현, 정렬
풀이 : https://cuckoobird.tistory.com/193
결과 : 맞았습니다 (메모리 14248KB | 시간 100ms | 코드 길이 1277B)
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Platform implements Comparable<Platform> {
		int y, x1, x2;
		
		public Platform(int y, int x1, int x2) {
			this.y = y;
			this.x1 = x1;
			this.x2 = x2;
		}
		
		@Override
		public int compareTo(Platform o) {
			return this.y - o.y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.valueOf(st.nextToken());
		
		PriorityQueue<Platform> pq = new PriorityQueue<>();
		for(int i=0 ; i<n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.valueOf(st.nextToken());
			int x1 = Integer.valueOf(st.nextToken());
			int x2 = Integer.valueOf(st.nextToken());
			
			pq.add(new Platform(y, x1, x2));
		}
		
		int ans=0;
		int[] lenList = new int[10001];
		
		while(!pq.isEmpty()) {
			Platform p = pq.poll();
			for(int i=p.x1; i<p.x2; i++) {
				if(i ==p.x1 || i==p.x2 - 1) {
					ans += p.y - lenList[i];
				}
				lenList[i]=p.y;
				
			}
		}
		
		System.out.println(ans);
		
	}
}

