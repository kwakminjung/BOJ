/*
백준 2493번 : 탑 (골드5)
알고리즘 분류 : 자료 구조, 스택
풀이 : https://cuckoobird.tistory.com/130
결과 : 맞았습니다 (메모리 92672KB | 시간 820ms | 코드 길이 1218B)
*/

import java.io.*;
import java.util.*;

class Top {
	int num;
	int height;
	
	Top(int num, int height){
		this.num = num;
		this.height = height;
	}
}

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int[] ans = new int[n];
		Stack<Top> tower = new Stack<>();
		for(int i = 1 ; i <= n ; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			if(tower.isEmpty()) {
				ans[i - 1] = 0;
				tower.push(new Top(i, height));
			} else {
				while(true) {
					if(tower.isEmpty()) {
						ans[i - 1] = 0;
						tower.push(new Top(i, height));
						break;
					}
					
					Top top = tower.peek();
					if(top.height > height) {
						ans[i - 1] = top.num;
						tower.push(new Top(i, height));
						break;
					} else {
						tower.pop();
					}
				}
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			bw.write(ans[i] + " ");
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
