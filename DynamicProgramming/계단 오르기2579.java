/*
백준 2579번 : 계단 오르기 (실버3)
알고리즘 분류 : 다이나믹 프로그래밍
풀이 : https://cuckoobird.tistory.com/200

Bottom-Up 방식
결과 : 맞았습니다 (메모리 14136KB | 시간 104ms | 코드 길이 	771B)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.valueOf(br.readLine());
		
		int[] stair = new int[n+1];
		for(int i=1; i<=n; i++) {
			stair[i] = Integer.valueOf(br.readLine());
		}
		
		int ans = solution(n, stair);
		System.out.println(ans);
	}
	
	public static int solution(int n, int[] stair) {
		int[] dp = new int[n+1];
		dp[0]=0;
		for(int i=1; i<=n; i++) {
			if(i == 1) dp[i] = stair[i];
			else if(i == 2) dp[i] = dp[i-1] + stair[i];
			else dp[i] = Math.max(dp[i-3]+stair[i-1]+stair[i], dp[i-2]+stair[i]);
		}
		
		return dp[n];
	}
}


/*
Top-Down 방식
결과 : 맞았습니다 (메모리 14212KB | 시간 100ms | 코드 길이 	771B)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static Integer[] dp;
	static int[] stair;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		
		stair = new int[n+1];
		dp = new Integer[n+1];
		for(int i=1; i<=n; i++) {
			stair[i] = Integer.valueOf(br.readLine());
		}
		dp[0] = 0;
		int ans = recur(n);
		System.out.println(ans);
	}
	public static int recur(int i) {
		if(i == 1) return stair[1];
		else if(i==2) return recur(i-1)+stair[2];
		if(dp[i] == null) {
			dp[i] = Math.max(recur(i-3) + stair[i-1], recur(i-2)) + stair[i];			
		}
		return dp[i];
	}
}
