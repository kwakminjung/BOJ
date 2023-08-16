/*
백준 1091번 : 카드 섞기 (골드4)
알고리즘 분류 : 구현, 시뮬레이션
풀이 : https://cuckoobird.tistory.com/135
결과 : 맞았습니다 (메모리 39552KB | 시간 200ms | 코드 길이 1253B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int[] s, p, tmp_p;
	private static int n;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(bf.readLine());
		
		p = new int[n];
		s = new int[n];
		tmp_p = new int[n];
		
		StringTokenizer st_p = new StringTokenizer(bf.readLine());
		StringTokenizer st_s = new StringTokenizer(bf.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			p[i] = Integer.parseInt(st_p.nextToken());
			s[i] = Integer.parseInt(st_s.nextToken());
		}
		
		int cnt = 0;
		tmp_p = p;
		
		while(!isTrue()) {
			if(isTrue()) break;
			
			mix();
			cnt ++;
			
			if(Arrays.equals(p, tmp_p)) {
				cnt = -1;
				break;
			}
		}
		
		bw.write(cnt + "\n");
		
		bf.close();
		bw.flush();
		bf.close();
	}
	
	public static boolean isTrue() {
		for(int i = 0 ; i < n ; i++) {
			if(tmp_p[i] != i % 3) return false;
		}
		return true;
	}
	
	public static void mix() {
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[s[i]] = tmp_p[i];
		}
		
		tmp_p = arr;
	}
}
