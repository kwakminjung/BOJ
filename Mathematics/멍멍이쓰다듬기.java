/*
백준 1669번 : 멍멍이 쓰다듬기 (골드5)
알고리즘 분류 : 수학
풀이 : https://cuckoobird.tistory.com/92
결과 : 맞았습니다 (메모리 14220KB | 시간 124ms | 코드 길이 898B)
*/

import java.util.*;
import java.io.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		if(m == d) {
			System.out.println(0);
			return;
		}
		
		double interval = d - m;
		
		double a = Math.sqrt(interval);
		
		if(a - (int)a > 0) {
			if(interval - Math.pow((int)a, 2) <= (int)a) {
				bw.write(Integer.toString((2 * (int)a - 1) + 1));
			}
			else {
				bw.write(Integer.toString((2 * (int)a - 1) + 2));
			}
		} else {
			bw.write(Integer.toString(2 * (int)a - 1));
			
		}
		
		bf.close();
		bw.close();
	}
}
