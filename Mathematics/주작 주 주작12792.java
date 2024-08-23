/*
백준 12792번 : 주작 주 주작(실버1)
알고리즘 분류 : 수학, 정수론
결과 : 틀렸습니다
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] idx;
	static boolean[] prime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		idx=new int[n];
		
		for(int i=0;i<n;i++) {
			idx[i]=Integer.valueOf(st.nextToken());
			if(i+1==idx[i]) {
				System.out.println("-1");
				return;
			}
		}
		solution(n);
		for(int i=prime.length-1;i>0; i--) {
			if(prime[i]==false) {
				System.out.println(i);
				return;
			}
		}
	}
	
	public static void solution(int n) {
		prime=new boolean[n+1];
		prime[0]=prime[1]=true;
		
		if(n<2) return;
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(prime[i]) continue;
			
			for(int j=i*i;j<prime.length;j=j*i) {
				prime[j]=true;
			}
		}
	}
}
