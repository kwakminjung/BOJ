/*
백준 5582번 : 공통 부분 문자열 (골드5)
알고리즘 분류 : 다이나믹 프로그래밍, 문자열
풀이 : https://cuckoobird.tistory.com/118
결과 : 맞았습니다 (메모리 76988KB | 시간 252ms | 코드 길이 818B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String str1 = bf.readLine();
		String str2 = bf.readLine();
		
		int[][] arr = new int[str1.length()][str2.length()];
		
		int ans = 0;
		
		for(int i = 0 ; i < str1.length() ; i++) {
			for(int j = 0 ; j < str2.length() ; j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					arr[i][j] = 1;
					if(i > 0 && j > 0) {
						arr[i][j] += arr[i-1][j-1];
					}
					ans = Math.max(ans, arr[i][j]);
				}
			}
		}
		
		bw.write(Integer.toString(ans));
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
