/*
백준 7453번 : 합이 0인 네 정수 (골드2)
알고리즘 분류 : 정렬, 두 포인터, 이분 탐색, 중간에서 만나기
풀이 : https://cuckoobird.tistory.com/145
결과 : 맞았습니다 (메모리 161828KB | 시간 4208ms | 코드 길이 1525B)
메모 : 
두 포인터를 이용한 방식
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] AB = new int[n * n];
		int[] CD = new int[n * n];
		
		int idx = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				AB[idx] = A[i] + B[j];
				CD[idx++] = C[i] + D[j];
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		long ans = 0;
		int start = 0, end = n * n - 1;
		while(start < n * n && end >= 0) {
			if(AB[start] + CD[end] < 0) start ++;
			else if(AB[start] + CD[end] > 0) end --;
			else {
				long leftCnt = 1, rightCnt = 1;
				while(start + 1 < n * n && (AB[start] == AB[start + 1])) {
					leftCnt ++;
					start ++;
				}
				while(end > 0 && (CD[end] == CD[end - 1])) {
					rightCnt ++;
					end --;
				}
				ans += leftCnt * rightCnt;
				start ++;
			}
		}
		
		bw.write(ans + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
