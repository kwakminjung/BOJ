/*
백준 1092번 : 배 (골드5)
알고리즘 분류 : 그리디 알고리즘, 정렬
풀이 : https://cuckoobird.tistory.com/108
결과 : 맞았습니다 (메모리 16592KB | 시간 340ms | 코드 길이 1322B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		ArrayList<Integer> n_arr = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0 ; i < n ; i++) {
			n_arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(n_arr, Collections.reverseOrder());
		
		int m = Integer.parseInt(bf.readLine());
		ArrayList<Integer> m_arr = new ArrayList<>();
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0 ; i < m ; i++) {
			m_arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(m_arr, Collections.reverseOrder());
		
		if(n_arr.get(0) < m_arr.get(0)) {
			bw.write("-1");
		} else {
			int ans = 0;
			while(!m_arr.isEmpty()) {
				int idx = 0;
				for(int i = 0 ; i < n_arr.size() ; ) {
					if(idx == m_arr.size()) break;
					else if(n_arr.get(i) >= m_arr.get(idx)) {
						m_arr.remove(idx);
						i ++;
					} 
					else idx ++;
				}
				ans ++;
			}			
			bw.write(Integer.toString(ans));
		}
		bf.close();
		bw.flush();
		bw.close();
	}
}
