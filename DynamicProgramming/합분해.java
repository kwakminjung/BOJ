/*
백준 2225번 : 합분해 (골드5)
알고리즘 분류 : 수학, 다이나믹 프로그래밍
풀이 : https://cuckoobird.tistory.com/93
결과 : 맞았습니다 (메모리 14524KB | 시간 152ms | 코드 길이 817B)
*/

import java.util.*;
import java.io.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[k + 1][n + 1];
		
		dp[0][0] = 1;
		
		for(int i = 1 ; i <= k ; i++) {
			for(int j = 0 ; j <= n ; j++) {
				for(int t = 0 ; t <= j ; t++) {
					dp[i][j] += dp[i-1][j-t];
                    dp[i][j] %= 1000000000;
				}
			}
		}
		
		bw.write(Integer.toString(dp[k][n]));
		
		bw.flush();
		bf.close();
		bw.close();
	}
}
