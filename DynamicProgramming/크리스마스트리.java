/*
백준 1234번 : 크리스마스 트리 (골드2)
알고리즘 분류 : 수학, 다이나믹 프로그래밍, 조합론
풀이 : https://cuckoobird.tistory.com/142
결과 : 맞았습니다 (메모리 34400KB | 시간 344ms | 코드 길이 2030B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		long[][][][] dp = new long[N + 1][R + 1][G + 1][B + 1];
		
		for(int n = 0 ; n <= N ; n++) {
			for(int r = 0 ; r <= R ; r++) {
				for(int g = 0 ; g <= G ; g++) {
					for(int b = 0 ; b <= B ; b++) {
                    	// 초기 세팅
						if(n == 0) {
							dp[n][r][g][b] = 1;
							continue;
						}
                        // 한 가지 색으로만 이루어져 있을 경우
						if(r - n >= 0) dp[n][r][g][b] += dp[n - 1][r - n][g][b] * 1;
						if(g - n >= 0) dp[n][r][g][b] += dp[n - 1][r][g - n][b] * 1;
						if(b - n >= 0) dp[n][r][g][b] += dp[n - 1][r][g][b - n] * 1;
						
                        // 두 가지 색으로 이루어져 있을 경우
						if(n % 2 == 0) {
							int divNum = n / 2;
							if(g - divNum >= 0 && b - divNum >= 0) 
								dp[n][r][g][b] += dp[n-1][r][g - divNum][b - divNum] * comb(n, divNum);
							if(r - divNum >= 0 && b - divNum >= 0) 
								dp[n][r][g][b] += dp[n-1][r - divNum][g][b - divNum] * comb(n, divNum);
							if(r - divNum >= 0 && g - divNum >= 0) 
								dp[n][r][g][b] += dp[n-1][r - divNum][g - divNum][b] * comb(n, divNum);
						}
						
                        // 세 가지 색으로 이루어져 있을 경우
						if(n % 3 == 0) {
							int divNum = n / 3;
							if(r - divNum >= 0 && g - divNum >= 0 && b - divNum >= 0) 
								dp[n][r][g][b] += dp[n-1][r - divNum][g - divNum][b - divNum] * comb(n, divNum) * comb(n - divNum, divNum);
						}
					}
				}
			}
		}
		
		bw.write(dp[N][R][G][B] + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	public static int comb(int n, int r) {
		return factorial(n) / (factorial(r) * factorial(n - r));
	}
	
	public static int factorial(int x) {
		if(x == 1) return 1;
		return x * factorial(x - 1);
	}
}
