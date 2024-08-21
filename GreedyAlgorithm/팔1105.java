/*
백준 1105번 : 팔 (실버1)
알고리즘 분류 : 수학, 그리디 알고리즘
풀이 : https://cuckoobird.tistory.com/204
결과 : 맞았습니다 (메모리 14224KB | 시간 100ms | 코드 길이 717B)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String L = st.nextToken();
		String R = st.nextToken();
		
		int ans=0;
		if(L.length() == R.length()) {
			for(int i=0; i<L.length()-1; i++) {
				if(L.charAt(i)=='8'&& L.charAt(i) == R.charAt(i)) ans ++;
				else if(L.charAt(i) != R.charAt(i)) break;
			}
            if(L.equals(R)&& L.charAt(L.length()-1)=='8') ans ++;
		}
		
		System.out.println(ans);
	}
}
