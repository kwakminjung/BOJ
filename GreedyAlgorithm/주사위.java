/*
백준 1041번 : 주사위 (골드5)
알고리즘 분류 : 수학, 그리디 알고리즘
풀이 : https://cuckoobird.tistory.com/129
결과 : 맞았습니다 (메모리 15800KB | 시간 140ms | 코드 길이 1373B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] dice = new int[6];
		int max = 0;
		long sum = 0;
		for(int i = 0 ; i < 6 ; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, dice[i]);
			sum += dice[i];
		}
		
		int side1 = INF, side2 = INF, side3 = INF;
		
		if(n == 1) {
			bw.write(sum - max + "\n");
			
			bf.close();
			bw.flush();
			bw.close();
			return;
		}
		
		for(int i = 0 ; i < 6 ; i++) {
			side1 = Math.min(side1, dice[i]);
			for(int j = i + 1 ; j < 6 ; j++) {
				if(i + j != 5) {
					side2 = Math.min(side2, dice[i] + dice[j]);
					for(int k = j + 1 ; k < 6 ; k++) {
						if(i + k != 5 && j + k != 5) {
							side3 = Math.min(side3, dice[i] + dice[j] + dice[k]);
						}
					}
				}
			}
		}
		
		sum = 0;
		sum += side3 * 4;
		sum += side2 * ((long) 8 * n - 12);
		sum += side1 * ((long) 5 * n * n - 16 * n + 12);
		
		bw.write(sum + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
