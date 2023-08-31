/*
백준 1135번 : 뉴스 전하기 (골드2)
알고리즘 분류 : 다이나믹 프로그래밍, 그리디 알고리즘, 정렬, 트리, 트리에서의 다이나믹 알고리즘
풀이 : https://cuckoobird.tistory.com/150
결과 : 맞았습니다 (메모리 15992KB | 시간 148ms | 코드 길이 1218B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int n;
	private static int[] dp;
	private static ArrayList<Integer>[] tree;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(bf.readLine());
		tree = new ArrayList[n];
		dp = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			tree[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			int input = Integer.parseInt(st.nextToken());
			if(input != -1) {
				tree[input].add(i);				
			}
		}
		
		bw.write(dfs(0) + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	public static int dfs(int cur) {
		int cnt = 0;
		int max = 0;
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
		for(Integer next : tree[cur]) {
			dp[next] = dfs(next);
			q.add(new int[] {next, dp[next]});
		}
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			cnt ++;
			max = Math.max(max, node[1] + cnt);
		}
		
		return max;
	}
}
