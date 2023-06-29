/*
백준 1593번 : 문자 해독 (골드5)
알고리즘 분류 : 문자열, 슬라이딩 윈도우
풀이 : https://cuckoobird.tistory.com/91
결과 : 맞았습니다 (메모리 26776KB | 시간 340ms | 코드 길이 1192B)

메모 :
문자열 비교 부분 - 크기 52(소문자+대문자) Sarr와 Warr 배열을 선언하여 Arrays.equals(Sarr, Warr) 로 배열이 같은지 비교할 수 있음
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int g = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		String W = bf.readLine();
		String S = bf.readLine();
		
		int[] Warr = new int[52];
		int[] Sarr = new int[52];
		
		for(char c : W.toCharArray()) {
			putWord(c, Warr, 1);
		}
		
		int start = 0, size = 0;
		int ans = 0;
		
		for(int i = 0 ; i < s ; i++) {
			char sc = S.charAt(i);
			putWord(sc, Sarr, 1);
			size ++;
			if(size == g) {
				if(Arrays.equals(Sarr, Warr)) {
					ans ++;
				}
				putWord(S.charAt(start), Sarr, -1);
				start ++;
				size --;
				
			}
		}
		
		bw.write(Integer.toString(ans));
		
		bf.close();
		bw.close();
	}
	
	static void putWord(char word, int[] arr, int dif) {
		if('a' <= word && word <= 'z') {
			arr[word - 'a'] += dif;
		}
		else {
			arr[word - 'A' + 26] += dif;
		}
	}
}
