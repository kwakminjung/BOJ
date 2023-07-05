/*
백준 12865번 : 평범한 배낭 (골드5)
알고리즘 분류 : 다이나믹 프로그래밍, 배낭 문제
풀이 : https://cuckoobird.tistory.com/97
결과 : 맞았습니다 (메모리 53980KB | 시간 196ms | 코드 길이 1069B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		
		for(int i = 1 ; i <= n ; i++) {
			StringTokenizer st_wv = new StringTokenizer(bf.readLine());
			w[i] = Integer.parseInt(st_wv.nextToken());
			v[i] = Integer.parseInt(st_wv.nextToken());
		}
		
		int[][] dp = new int[n +1 ][k + 1];
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1; j <= k ; j++) {
				if(w[i] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j - w[i]] + v[i], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		bw.write(Integer.toString(dp[n][k]));
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
