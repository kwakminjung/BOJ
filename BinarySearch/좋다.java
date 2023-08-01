/*
백준 1253번 : 좋다 (골드4)
알고리즘 분류 : 자료 구조, 정렬, 이분 탐색, 해시를 사용한 집합과 맵, 두 포인터
풀이 : https://cuckoobird.tistory.com/120
결과 : 맞았습니다 (메모리 15176KB | 시간 200ms | 코드 길이 926B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int cnt = 0;
		for(int i = 0 ; i < n ; i++) {
			int a = 0 , b = n - 1;
			while(a < b) {
				if(arr[i] == arr[a] + arr[b]) {
					if(i == a) a++;
					else if(i == b) b--;
					else {
						cnt ++;
						break;
					}
				}
				else if(arr[i] < arr[a] + arr[b]) b--;
				else a++;
			}
			
		}
		
		bw.write(cnt + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
}
