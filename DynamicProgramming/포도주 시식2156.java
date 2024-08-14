/*
백준 2156번 : 포도주 시식 (실버1)
알고리즘 분류 : 다이나믹 프로그래밍
결과 : 맞았습니다 (메모리 15008KB | 시간 120ms | 코드 길이 	808B)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] juice = new int[n+1];
		for(int i=1; i<=n ;i++) {
			juice[i] = Integer.valueOf(br.readLine());
		}
		int ans = solution(n, juice);
		System.out.println(ans);
	}
	
	public static int solution(int n, int[] juice) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		
		for(int i=1; i<=n; i++) {
			if(i == 1) {
				dp[i] = juice[i];
			} else if(i==2) {
				dp[i] = juice[i-1] + juice[i];
			} else {
				dp[i] = Math.max(Math.max(dp[i-3] + juice[i-1], dp[i-2]) + juice[i], dp[i-1]);
			}
		}
		
		return dp[n];
	}
}
