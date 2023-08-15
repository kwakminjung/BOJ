/*
백준 1034번 : 램프 (골드4)
알고리즘 분류 : 브루트포스 알고리즘, 애드 혹
풀이 : https://cuckoobird.tistory.com/134
결과 : 맞았습니다 (메모리 15912KB | 시간 152ms | 코드 길이 1036B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[n];
		for(int i = 0 ; i < n ; i++) {
			String input = bf.readLine();
			arr[i] = input;
		}
		
		int k = Integer.parseInt(bf.readLine());
		
		int ans = 0;
		for(int i = 0 ; i < n ; i++) {
			int zero = 0;
			for(int j = 0 ; j < m ; j++) {
				if(arr[i].charAt(j) == '0') zero ++;
			}
			
			int same = 0;
			if(zero <= k && zero % 2 == k % 2) {
				for(int j = 0 ; j < n ; j++) {
					if(arr[i].equals(arr[j])) same ++;
				}
			}
			ans = Math.max(same, ans);
		}
		bw.write(ans + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
