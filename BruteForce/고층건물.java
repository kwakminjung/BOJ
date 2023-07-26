/*
백준 1027번 : 고층 건물 (골드4)
알고리즘 분류 : 수학, 브루트포스 알고리즘, 기하학
풀이 : https://cuckoobird.tistory.com/115
결과 : 맞았습니다 (메모리 14232KB | 시간 132ms | 코드 길이 1118B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] tower = new int[n];
		for(int i = 0 ; i < n ; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for(int i = 0 ; i < n ; i++) {
			int cnt = 0;
			
            // 왼쪽 그래프 탐색 : max_l 보다 기울기가 작거나 같다면 건물을 지나치거나 겹칩
			double max_l = 1_000_000_000;
			for(int j = i-1 ; j >= 0 ; j--) {
				double l = (tower[i]-tower[j]) / ((double)i - (double)j);
				if(l < max_l) {
					cnt ++;
					max_l = l;
				}
			}
			
            // 오른쪽 그래프 탐색 : min_l 보다 기울기가 크거나 같다면 건물을 지나치거나 겹칩
			double min_l = -1_000_000_000;
			for(int j = i+1 ; j < n ; j++) {
				double l = (tower[i]-tower[j]) / ((double)i - (double)j);
				if(l > min_l) {
					cnt ++;
					min_l = l;
				}
			}
			
			ans = Math.max(ans, cnt);
		}
		
		bw.write(Integer.toString(ans));
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
