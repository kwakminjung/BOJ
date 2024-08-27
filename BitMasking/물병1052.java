/*
백준 1052번 : 물병 (골드5)
알고리즘 분류 : 수학, 그리디 알고리즘, 비트마스킹
풀이 : https://cuckoobird.tistory.com/208
결과 : 맞았습니다 (메모리 	14308KB | 시간 108ms)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int ans = solution(n, k);
		System.out.println(ans);
	}
	
	public static int solution(int n, int k) {
		int ans = 0;
		while(Integer.bitCount(n) > k) {
			n ++;
			ans ++;
		}
		return ans;
	}
}
