/*
백준 1423번 : 원숭이 키우기 (골드3)
알고리즘 분류 : 다이나믹 프로그래밍
풀이 : https://cuckoobird.tistory.com/126
결과 : 맞았습니다 (메모리 17240KB | 시간 264ms | 코드 길이 1325B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		
		int[] level_num = new int[n + 1];
		int[] strength = new int[n + 1];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 1 ; i <= n ; i++) {
			level_num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for(int i = 1 ; i <= n ; i++) {
			strength[i] = Integer.parseInt(st.nextToken());
		}
		
		int d = Integer.parseInt(bf.readLine());
		
		long initial = 0;
		for(int i = 1 ; i <= n ; i++) {
			initial += (long) level_num[i] * strength[i];
			level_num[i] = Math.min(d, level_num[i]);
		}
		
		long[] dp = new long[d + 1];
		
		for(int i = 1 ; i <= n ; i++) {
			while(level_num[i] > 0) {
				for(int j = d ; j >= 0 ; j--) {
					for(int k = i + 1 ; k <= n && k + j - i <= d ; k++) {
						dp[k + j - i] = Math.max(dp[k + j - i], dp[j] + strength[k] - strength[i]);
					}
				}
				level_num[i]--;
			}
		}
		
		bw.write((initial + dp[d]) + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
