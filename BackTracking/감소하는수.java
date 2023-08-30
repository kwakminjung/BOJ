/*
백준 1038번 : 감소하는 수 (골드5)
알고리즘 분류 : 브루트포스 알고리즘, 백트래킹
풀이 : https://cuckoobird.tistory.com/149
결과 : 맞았습니다 (메모리 15840KB | 시간 152ms | 코드 길이 859B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static ArrayList<Long> list;
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		
		list = new ArrayList<>();
		if(n <= 10) bw.write(n + "\n");
		else if(n > 1022) bw.write("-1");
		else {
			for(int i = 0 ; i < 10 ; i++) {
				solution(i, 1);
			}
			Collections.sort(list);
			bw.write(list.get(n) + "\n");
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	public static void solution(long num, int idx) {
		if(idx > 10) return;
		list.add(num);
		for(int i = 0 ; i < num % 10 ; i++) {
			solution((num * 10) + i, idx + 1);
		}
	}
}
