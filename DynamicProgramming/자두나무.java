/*
백준 2240번 : 자두나무 (골드5)
알고리즘 분류 : 다이나믹 프로그래밍
풀이 : https://cuckoobird.tistory.com/113
결과 : 맞았습니다 (메모리 14264KB | 시간 124ms | 코드 길이 1297B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[t+1][w+1];
		
		for(int i = 1 ; i <= t ; i++) {
			int p = Integer.parseInt(bf.readLine());
			
			for(int j = 0 ; j <= w ; j++) {
				if(j == 0) {
					if(p == 1) {
						dp[i][j] = dp[i-1][j] + 1;
					} else {
						dp[i][j] = dp[i-1][j];
					}
					continue;
				}
				
				if(j % 2 == 0) {
					if(p == 1) {
						dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
					} else {
						dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
					}
				} else {
					if(p == 1) {
						dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
					} else {
						dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
					}
				}
			}
		}
		int ans = 0;
		for(int i = 0 ; i <= w ; i++) {
			ans = Math.max(ans, dp[t][i]);
		}
		
		bw.write(Integer.toString(ans));
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
