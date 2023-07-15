/*
백준 6198번 : 옥상 정원 꾸미기 (골드5)
알고리즘 분류 : 자료 구조, 스택
풀이 : https://cuckoobird.tistory.com/105
결과 : 맞았습니다 (메모리 24088KB | 시간 312ms | 코드 길이 777B)
메모 :
스택의 활용
*/

import java.io.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		
		int[] building = new int[n];
		for(int i = 0 ; i < n ; i++) {
			building[i] = Integer.parseInt(bf.readLine());
		}
		int sum = 0;
		for(int i = 0 ; i < n ; i++) {
			int cnt = 0;
			for(int j = i + 1 ; j < n ; j++) {
				if(building[i] <= building[j]) break;
				else cnt++;
			}
			sum += cnt;
		}
		
		bw.write(Integer.toString(sum));
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
