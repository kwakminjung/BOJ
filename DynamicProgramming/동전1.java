/*
백준 2293번 : 동전 1 (골드5)
알고리즘 분류 : 다이나믹 프로그래밍
풀이 : https://cuckoobird.tistory.com/90
결과 : 맞았습니다 (메모리 14128KB | 시간 140ms | 코드 길이 793B)
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
		
		int[] coin = new int[n];
		int[] dp = new int[k + 1];
		
		dp[0] = 1;
		
		for(int i = 0 ; i < n ; i++) {
			coin[i] = Integer.parseInt(bf.readLine());
			for(int j = coin[i] ; j <= k ; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
		
		bw.write(Integer.toString(dp[k]));
		
		bw.flush();
		bf.close();
		bw.close();
	}
}
