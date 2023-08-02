/*
백준 3020번 : 개똥벌레 (골드5)
알고리즘 분류 : 이분 탐색, 누적 합
풀이 : https://cuckoobird.tistory.com/121
결과 : 맞았습니다 (메모리 30924KB | 시간 352ms | 코드 길이 1039B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[] up = new int[h+1];
		int[] down = new int[h+1];
		for(int i = 0 ; i < n ; i++) {
			int tmp = Integer.parseInt(bf.readLine());
			// 인덱스는 장애물의 크기임
			// 석순의 장애물 누적
			if(i % 2 == 0) down[tmp]++;
			// 종유석의 장애물 누적
			else up[h - tmp + 1]++;
		}
		
		// 종유석과 석순의 장애물 누적
		// 종유석은 인덱스가 작은 장애물을 긴 장애물에 더해주고 
		// (인덱스가 클수록 밑으로 뻗었다는 뜻이니 작은 인덱스를 지나면 큰 인덱스를 무조건 지나게 되기 때문)
		// 석순은 큰 장애물을 작은 장애물에 더해줌
		// (인덱스가 작을수록 작은 크기의 석순이라는 뜻이니 키 작은 석순을 지나면 키 큰 석순을 무조건 지나게 되기 때문)
		for(int i = 1 ; i <= h ; i++) {
			up[i] += up[i - 1];
			down[h - i] += down[h - i + 1];
		}
		
		int ans = 200_000;
		int cnt = 0;
		for(int i = 1 ; i <= h ; i++) {
			// 파괴될 벽의 최소값을 구함
			if(up[i] + down[i] < ans) {
				cnt = 1;
				ans = up[i] + down[i];
			}
			// 구간의 개수를 구함
			else if(up[i] + down[i] == ans) cnt++;
		}
		
		// 파괴될 벽의 최소와 그러한 구간 개수
		bw.write(ans + " " + cnt);
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
