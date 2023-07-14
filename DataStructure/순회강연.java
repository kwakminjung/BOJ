/*
백준 2109번 : 순회강연 (골드3)
알고리즘 분류 : 자료 구조, 그리디 알고리즘, 정렬, 우선순위 큐
풀이 : https://cuckoobird.tistory.com/104
결과 : 맞았습니다 (메모리 20232KB | 시간 316ms | 코드 길이 1289B)
메모 :
나중에 다시 보기 - 큐사용법, 정렬 위주
*/

import java.io.*;
import java.util.*;

class Req {
	int p, d;
	
	public Req(int p, int d) {
		this.p = p;
		this.d = d;
	}
}

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		
		PriorityQueue<Req> pq = new PriorityQueue<>((o1, o2) -> {
			if(o1.p == o2.p) return o1.d - o2.d;
			return o2.p - o1.p;
		});
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int tmp_p = Integer.parseInt(st.nextToken());
			int tmp_d = Integer.parseInt(st.nextToken());
			
			pq.add(new Req(tmp_p, tmp_d));
		}
		
		int ans = 0;
		boolean[] scheduled = new boolean[10001];
		while(!pq.isEmpty()) {
            Req cur = pq.poll();
            
            for(int i = cur.d ; i > 0 ; --i) {
                if(!scheduled[i]) {
                    scheduled[i] = true;
                    ans += cur.p;
                    break;
                }
            }
        }
        bw.write(Integer.toString(ans));
        
        bf.close();
        bw.flush();
        bw.close();
	}
}
