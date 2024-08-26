/*
백준 1111번 : IQ TEST (골드3)
알고리즘 분류 : 수학, 구현, 브루트포스 알고리즘, 많은 조건 분기
풀이 : https://cuckoobird.tistory.com/207
결과 : 맞았습니다 (메모리 14220KB | 시간 100ms)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		String ans = solution(arr, n);
		System.out.print(ans);
	}
	
	public static String solution(int[] arr, int n) {
		if(n == 1) return "A";
		
		if(n == 2) {
			if(arr[0] == arr[1]) {
				if(arr[0]==0) return "0";
				else return String.valueOf(arr[1]*(arr[1]/arr[0]));
			} else return "A";
		}
		
		int x1 = arr[0];
        int x2 = arr[1];
        int x3 = arr[2];

        int a = (x2 != x1) ? (x3 - x2) / (x2 - x1) : 0;
        int b = x2 - x1 * a;
		
		for(int i=1; i<n-1; i++) {
			int x = arr[i];
			int y = arr[i+1];
			if(x*a+b != y) return "B";
		}
		
		return String.valueOf(arr[n-1]*a+b);
	}
	
}
