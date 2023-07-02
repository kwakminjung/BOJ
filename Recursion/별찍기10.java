/*
백준 2447번 : 별 찍기 - 10 (골드5)
알고리즘 분류 : 분할 정복, 재귀
풀이 : https://cuckoobird.tistory.com/94
결과 : 맞았습니다 (메모리 16784KB | 시간 556ms | 코드 길이 745B)
메모 : 
재귀 함수
*/

import java.io.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				draw_square(i, j, n);
			}
			bw.write("\n");
		}
        bw.flush();
		bw.close();
		bf.close();
	}
	
	private static void draw_square(int i, int j, int n) throws IOException {
		if(i / n % 3 == 1 && j / n % 3 == 1) {
			bw.write(" ");
		}
		else if(n / 3 == 0) {
			bw.write("*");
		}
		else {
			draw_square(i, j, n/3);
		}
	}
}
