/*
백준 1516번 : 게임 개발 (골드3)
알고리즘 분류 : 다이나믹 프로그래밍, 그래프 이론, 위상 정렬
풀이 : https://cuckoobird.tistory.com/127
결과 : 맞았습니다 (메모리 22284KB | 시간 292ms | 코드 길이 1443B)
메모 : 
위상 정렬 개념 기억하기
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int n;
	private static int[] indegree;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(bf.readLine());
		indegree = new int[n + 1];
		
		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		for(int i = 1 ; i <= n ; i++) {
			graph[i] = new ArrayList<>();
		}
		
		PriorityQueue<Integer> Q = new PriorityQueue<>();
		
		StringTokenizer st;
		int[] time = new int[n + 1];
		int[] ans = new int[n + 1];
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(bf.readLine());
			
			time[i] = Integer.parseInt(st.nextToken());
			
			while(true) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == -1) {
					if(indegree[i] == 0) {
						ans[i] = time[i];
						Q.offer(i);
					}
					break;
				}
				else {
					graph[tmp].add(i);
					indegree[i]++;
				}
			}
		}
		
		while(!Q.isEmpty()) {
			int front = Q.poll();
			for(int next : graph[front]) {
				indegree[next]--;
				ans[next] = Math.max(ans[next], time[next] + ans[front]);
				if(indegree[next] == 0) {
					Q.offer(next);
				}
			}
		}
		for(int i = 1 ; i <= n ; i++) {
			bw.write(ans[i] + "\n");
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
