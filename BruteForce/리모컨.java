/*
백준 1107번 : 리모컨 (골드5)
알고리즘 분류 : 브루트포스 알고리즘
풀이 : https://cuckoobird.tistory.com/137
결과 : 맞았습니다 (메모리 64900KB | 시간 336ms | 코드 길이 1273B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static boolean[] broken = new boolean[10];
	private static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		ans = Math.abs(100 - n);
		
		int m = Integer.parseInt(bf.readLine());
		
		if(m == 0) {
			ans = Math.min(ans, String.valueOf(n).length());
			
			bw.write(ans + "\n");
			bw.flush();
			bw.close();
			bf.close();
			
			return;
		}
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0 ; i < m ; i++) {
			int t = Integer.parseInt(st.nextToken());
			broken[t] = true;
		}
		
		for(int i = 0 ; i <= 999_999 ; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			boolean isBreak = false;
			for(int j = 0 ; j < len ; j++) {
				if(broken[str.charAt(j) - '0']) {
					isBreak = true;
					break;
				}
			}
			
			if(!isBreak) {
				int min = Math.abs(n - i) + len;
				ans = Math.min(ans, min);
			}
			
		}
		
		bw.write(ans + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
