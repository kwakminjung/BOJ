/*
백준 1756번 : 피자 굽기 (골드5)
알고리즘 분류 : 구현
풀이 : https://cuckoobird.tistory.com/116
결과 : 맞았습니다 (메모리 65468KB | 시간 524ms | 코드 길이 1098B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] oven = new int[d];
		int[] pizza = new int[n];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0 ; i < d ; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
			if(i > 0 && oven[i-1] <= oven[i]) oven[i] = oven[i-1];
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0 ; i < n ; i++) {
			pizza[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int cnt = 0;
		for(int i = d-1 ; i >= 0; i--) {
			if(oven[i] >= pizza[cnt]) {
				cnt++;
			}
			if(cnt == n) {
				ans = i + 1;
				break;
			}
		}
		
		bw.write(Integer.toString(ans));
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
