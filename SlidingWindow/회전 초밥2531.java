/*
백준 2531번 : 회전 초밥 (실버1)
알고리즘 분류 : 브루트포스 알고리즘, 두 포인터, 슬라이딩 윈도우
풀이 : 
결과 : 틀렸습니다
*/

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class b2531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n, d, k, c;
		n = Integer.valueOf(st.nextToken());
		d = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		c = Integer.valueOf(st.nextToken());
		
		int[] sushi = new int[n];
		int[] flavor = new int[d];
		int ans = 0;
		for(int i=0; i<n; i++) {
			sushi[i] = Integer.valueOf(br.readLine());
			flavor[sushi[i]-1]++;
			if(flavor[sushi[i]-1] == 1) ans ++;
		}
		if(sushi.length >= k) {
			ans = solution(sushi, flavor, n, k, c);
		}
		System.out.println(ans);
	}
	
	public static int solution(int[] sushi, int[] flavor, int n, int k, int c) {
		int left = 0, right = k-1;
		int ans = 0;
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<k ;i++) {
			set.add(sushi[i]);
		}
		set.add(c);
		if(ans < set.size()) ans = set.size();
		
		for(int i=0; i<n; i++) {
			left++;
			if(flavor[sushi[left-1]-1] <= 1) set.remove(sushi[left-1]);
			
			right++;
			set.add(sushi[right%n]);
			set.add(c);
			
			if(ans < set.size()) ans = set.size();
		}
		return ans;
	}
}
