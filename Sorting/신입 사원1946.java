/*
백준 1946번 : 신입 사원 (실버1)
알고리즘 분류 : 그리디 알고리즘, 정렬
풀이 : https://cuckoobird.tistory.com/195
결과 : 맞았습니다 (메모리 298316KB | 시간 868ms | 코드 길이 1048B)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int t = Integer.valueOf(st.nextToken());
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(st.nextToken());
			
			int[] arr = new int[n+1];
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				int f = Integer.valueOf(st.nextToken());
				int s = Integer.valueOf(st.nextToken());
				arr[f] = s;
			}
			int ans = solution(arr, n);
			System.out.println(ans);
		}
	}
	
	public static int solution(int[] arr, int n) {
		int ans = 1;
		int top = arr[1];
		for(int i=2; i<=n; i++) {
			if(top > arr[i]) {
				top = arr[i];
				ans += 1;
			}
		}
		return ans;
	}

}
