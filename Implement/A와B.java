/*
백준 12904번 : A와 B (골드5)
알고리즘 분류 : 구현, 문자열, 그리디 알고리즘
풀이 : https://cuckoobird.tistory.com/103
결과 : 맞았습니다 (메모리 14420KB | 시간 148ms | 코드 길이 928B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String s = bf.readLine();
		String t = bf.readLine();
		
		ArrayList<Character> T = new ArrayList<>();
		
		for(int i = 0 ; i < t.length() ; i++) {
			T.add(t.charAt(i));
		}
		
		while(s.length() < T.size()) {
			if(T.get(T.size() - 1) == 'A') {
				T.remove(T.size() - 1);
			} else {
				T.remove(T.size() - 1);
				Collections.reverse(T);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character ch : T) {
			sb.append(ch);
		}
		
		String result = sb.toString();
		
		if(result.equals(s)) {
			bw.write("1");
		} else {
			bw.write("0");
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
