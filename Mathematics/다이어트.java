/*
백준 1484번 : 다이어트 (골드5)
알고리즘 분류 : 수학, 두 포인터
풀이 : https://cuckoobird.tistory.com/114
결과 : 맞았습니다 (메모리 15936KB | 시간 152ms | 코드 길이 677B)
*/

import java.io.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int g = Integer.parseInt(bf.readLine());
		
		int a = 1, b = 1;
		
		boolean flag = false;
		
		while(b < 100_000) {
			int dif = a*a - b*b;
			
			if(a-b == 1 && dif > g) break;
			
			if (dif > g) b ++;
			else if(dif < g) a ++;
			else {
				bw.write(a + "\n");
				flag = true;
				a ++;
			}
		}
		if(!flag) bw.write("-1");
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
