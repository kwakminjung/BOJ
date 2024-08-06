/*
백준 1581번 : 락스타 락동호 (골드4)
알고리즘 분류 : 많은 조건 분기
풀이 : https://cuckoobird.tistory.com/194
결과 : 맞았습니다 (메모리 14244KB | 시간 100ms | 코드 길이 799B)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int ff = Integer.valueOf(st.nextToken());
		int fs = Integer.valueOf(st.nextToken());
		int sf = Integer.valueOf(st.nextToken());
		int ss = Integer.valueOf(st.nextToken());
		
		System.out.println(solution(ff, fs, sf, ss));
	}
	
	public static int solution(int ff, int fs, int sf, int ss) {
		if(ff == 0 && fs == 0) return ss + Math.min(sf, 1);
		if(fs == 0) return ff;
		if(fs > sf) return 2*sf + 1 + ss + ff;
		else return 2*fs + ss + ff;
	}
}
