/*
백준 5430번 : AC (골드5)
알고리즘 분류 : 구현, 자료 구조, 문자열, 파싱, 덱
풀이 : https://cuckoobird.tistory.com/140
결과 : 맞았습니다 (메모리 92704KB | 시간 916ms | 코드 길이 1460B)
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
			boolean err = false;
			
			String p = bf.readLine();
			int n = Integer.parseInt(bf.readLine());
            // StringTokenizer 을 이용한 입력 (두번째 인자는 구분자)
			StringTokenizer st = new StringTokenizer(bf.readLine(), "[],");
			Deque<Integer> deque = new ArrayDeque<>();
			
			for(int i = 0 ; i < n ; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			int r = 0;
			for(int i = 0 ; i < p.length() ; i++) {
				if(p.charAt(i) == 'R') {
					r++;
				}
				else {
					n--;
                    // 덱이 비었음
					if(n < 0) {
						err = true;
						break;
					}
                    // 뒤집기 짝수면 덱 순서가 그대로이므로 pollFirst
					if(r % 2 == 0) {
						deque.pollFirst();
                    // 뒤집기 홀수면 덱 순서가 반대이므로 pollLast
					} else {
						deque.pollLast();
					}
				}
			}
			
			if(err) {
				bw.write("error\n");
				continue;
			}
			
			bw.write("[");
			if(r % 2 == 0) {
				while(!deque.isEmpty()) {
					bw.write(deque.pollFirst() + "");
					if(deque.size() > 0) {
						bw.write(",");
					}
				}
			} else {
				while(!deque.isEmpty()) {
					bw.write(deque.pollLast() + "");
					if(deque.size() > 0) {
						bw.write(",");
					}
				}
			}
			bw.write("]\n");
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
