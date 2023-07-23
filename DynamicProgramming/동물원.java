/*
백준 1309번 : 동물원 (실버1)
알고리즘 분류 : 다이나믹 프로그래밍
풀이 : https://cuckoobird.tistory.com/112
결과 : 맞았습니다 (메모리 17148KB | 시간 160ms | 코드 길이 681B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(3);
		
		for(int i = 2 ; i <= n ; i++) {
			int pp = arr.get(i - 2) % 9901;
			int p = arr.get(i - 1) % 9901;
			
			arr.add(pp*3 + (p-pp)*2);
		}
		
		bw.write(Integer.toString(arr.get(n) % 9901));
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
