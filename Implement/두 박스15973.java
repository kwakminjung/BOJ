/*
백준 15973번 : 두 박스 (실버 1)
알고리즘 분류 : 구현, 기하학, 많은 조건 분기
풀이 : https://cuckoobird.tistory.com/197
결과 : 100점 (메모리 14368KB | 시간 100ms | 코드 길이 1382B)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] square = new int[2][4];
		
		for(int i=0; i<2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			square[i][0] = Integer.valueOf(st.nextToken());
			square[i][1] = Integer.valueOf(st.nextToken());
			square[i][2] = Integer.valueOf(st.nextToken());
			square[i][3] = Integer.valueOf(st.nextToken());
		}
		
		String ans = solution(square);
		System.out.println(ans);
	}
	
	public static String solution(int[][] square) {
		if(square[0][2] < square[1][0] || square[1][2] < square[0][0] || square[0][3] < square[1][1] || square[1][3] < square[0][1])
			return "NULL";
		else if((square[0][0] == square[1][2] && square[0][1] == square[1][3]) ||
				(square[0][2] == square[1][0] && square[0][1] == square[1][3]) ||
				(square[0][0] == square[1][2] && square[0][3] == square[1][1]) ||
				(square[0][2] == square[1][0] && square[0][3] == square[1][1]))
			return "POINT";
		else if(square[0][0] == square[1][2] || square[0][2] == square[1][0] ||
				square[0][1] == square[1][3] || square[0][3] == square[1][1])
			return "LINE";
		else
			return "FACE";
	}
	
	

}
