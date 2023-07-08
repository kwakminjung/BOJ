/*
백준 1339번 : 단어 수학 (골드4)
알고리즘 분류 : 그리디 알고리즘
풀이 : https://cuckoobird.tistory.com/100
결과 : 맞았습니다 (메모리 14296KB | 시간 132ms | 코드 길이 1049B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] alphabet = new int[26];
		
		for(int i = 0 ; i < n ; i++) {
			int cnt = 0;
			StringTokenizer st_alphabet = new StringTokenizer(bf.readLine());
			String str = st_alphabet.nextToken();
			cnt = str.length();
			for(int j = 0 ; j < str.length() ; j++) {
				char ch = str.charAt(j);
				alphabet[ch - 65] += (int) (Math.pow(10, cnt--)/10);
			}
		}
		Arrays.sort(alphabet);
		int ans = 0;
		int s = 9;
		for(int i = alphabet.length - 1 ; i >= 0 ; i--) {
			if(alphabet[i] == 0) {
				break;
			}
			ans += (s--) * alphabet[i];
		}
		
		bw.write(Integer.toString(ans));
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
