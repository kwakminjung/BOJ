/*
백준 10830번 : 행렬 제곱 (골드4)
알고리즘 분류 : 수학, 분할 정복, 분할 정복을 이용한 거듭제곱, 선형대수학
풀이 : https://cuckoobird.tistory.com/143
결과 : 맞았습니다 (메모리 15884KB | 시간 144ms | 코드 길이 1438B)
메모 :
분할 정복 알고리즘 다시 보기
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int n;
	private static int[][] a;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		a = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0 ; j < n ; j++) {
				a[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		int[][] ans = pow(a, b);
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				bw.write(ans[i][j] + " ");
			}
			bw.write("\n");
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
    // 분할 정복을 이용한 행렬의 제곱
	public static int[][] pow(int[][] A, long exp) {
		if(exp == 1L) {
			return A;
		}
		
		int[][] ret = pow(A, exp / 2);
		ret = matrixPow(ret, ret);
		
		if(exp % 2 == 1L) {
			ret = matrixPow(ret, a);
		}
		
		return ret;
	}
    
	// o1 행렬과 o2 행렬의 곱
	public static int[][] matrixPow(int[][] o1, int[][] o2) {
		int[][] ans = new int[n][n];

		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				for(int k = 0 ; k < n ; k++) {
					ans[i][j] += o1[i][k] * o2[k][j];
					ans[i][j] %= 1000;
				}
			}
		}
		
		return ans;
	}
}
