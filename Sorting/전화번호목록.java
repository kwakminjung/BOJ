/*
백준 5052번 : 전화번호 목록 (골드4)
알고리즘 분류 : 자료 구조, 문자열, 정렬, 트리, 트라이
풀이 : https://cuckoobird.tistory.com/138
결과 : 맞았습니다 (메모리 33276KB | 시간 656ms | 코드 길이 846B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(bf.readLine());
		
		while(t > 0) {
			t--;
			boolean flag = true;
			
			int n = Integer.parseInt(bf.readLine());
			
			String[] arr = new String[n];
			
			for(int i = 0 ; i < n ; i++) {
				arr[i] = bf.readLine();
			}
			
			Arrays.sort(arr);
			for(int i = 0 ; i < n - 1 ; i++) {
				if(arr[i + 1].startsWith(arr[i])) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
