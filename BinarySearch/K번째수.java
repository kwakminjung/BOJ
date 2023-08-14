/*
백준 1300번 : K번째 수 (골드2)
알고리즘 분류 : 이분 탐색, 매개 변수 탐색
풀이 : https://cuckoobird.tistory.com/133
결과 : 맞았습니다 (메모리 15896KB | 시간 184ms | 코드 길이 710B)
*/

import java.io.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		int k = Integer.parseInt(bf.readLine());
		
		long start = 1;
		long end = k;
		
		while(start < end) {
			long mid = (start + end) / 2;
			long cnt = 0;
			
			for(int i = 1 ; i <= n ; i++) {
				cnt += Math.min(mid / i, n);
			}
			
			if(k <= cnt) end = mid;
			else start = mid + 1;
		}
		
		bw.write(start + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
