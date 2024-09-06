/*
백준 2212번 : 센서 (골드5)
알고리즘 분류 : 그리디 알고리즘, 정렬
풀이 : https://cuckoobird.tistory.com/209
결과 : 맞았습니다 (메모리 17248KB | 시간 164ms)
*/

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int k = Integer.valueOf(br.readLine());
		
		int answer = 0;
		if(n > k) {
			int[] sensor = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n ; i++) {
				sensor[i] = Integer.valueOf(st.nextToken());
			}
			Arrays.sort(sensor);
			
			int[] gap = new int[n-1];
			for(int i=0; i<n-1; i++) {
				gap[i] = sensor[i+1] - sensor[i];
			}
			Arrays.sort(gap);
			
			for(int i=0; i<n-1-(k-1); i++) {
				answer += gap[i];
			}
		}
		System.out.println(answer);		
	}
}
