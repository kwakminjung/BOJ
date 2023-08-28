/*
백준 1461번 : 도서관 (골드4)
알고리즘 분류 : 그리디 알고리즘, 정렬
풀이 : https://cuckoobird.tistory.com/147
결과 : 맞았습니다 (메모리 16064KB | 시간 148ms | 코드 길이 1418B)
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
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> nq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		st = new StringTokenizer(bf.readLine());
		for(int i = 0 ; i < n ; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp >= 0) {
				pq.offer(tmp);
			} else {
            	// 절댓값으로 저장
				nq.offer(Math.abs(tmp));
			}
		}
		
        // 절댓값이 가장 큰 위치는 가장 마지막에 가야함
		int maxV = 0;
		if(pq.isEmpty()) maxV = nq.peek();
		else if(nq.isEmpty()) maxV = pq.peek();
		else maxV = Math.max(pq.peek(), nq.peek());
		
		int ans = 0;
		while(!pq.isEmpty()) {
        	// m개의 그룹에서 가장 큰 숫자 큐에서 poll하여 tmp에 저장
			int tmp = pq.poll();
            // m - 1개 poll (위 코드에서 1개 뺐으므로)
			for(int i = 0 ; i < m - 1 ; i++) {
				pq.poll();
				if(pq.isEmpty()) {
					break;
				}
			}
            // 왔다 갔다 할 때는 항상 m(혹은 그 이하)개의 그룹에서 가장 큰 수 * 2한 값을 이동
			ans += tmp * 2;
		}
		
		while(!nq.isEmpty()) {
			int tmp = nq.poll();
			for(int i = 0 ; i < m - 1; i++) {
				nq.poll();
				if(nq.isEmpty()) {
					break;
				}
			}
			ans += tmp * 2;
		}
		
        // 모든 위치 중 가장 큰 위치는 한 번의 이동으로 감 (0으로 돌아가지 않음)
		ans -= maxV;
		bw.write(ans + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
