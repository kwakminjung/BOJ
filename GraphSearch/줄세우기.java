/*
백준 2252번 : 줄 세우기 (골드3)
알고리즘 분류 : 그래프 이론, 위상 정렬
풀이 : https://cuckoobird.tistory.com/152
결과 : 맞았습니다 (메모리 46596KB | 시간 500ms | 코드 길이 1310B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		int[] indegree = new int[n + 1];
		
		for(int i = 1 ; i <= n ; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[b].add(s);
			indegree[s]++;
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 1 ; i <= n ; i++) {
			if(indegree[i] == 0) {
				arr.add(i);
			}
		}
		
		int start = 0;
		while(start < n) {
			int front = arr.get(start);
			for(int next : graph[front]) {
				indegree[next] --;
				if(indegree[next] == 0) {
					arr.add(next);
				}
			}
			start ++;
		}
		
		for(int i = n - 1 ; i >= 0 ; i--) {
			bw.write(arr.get(i) + " ");
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
