/*
백준 1781번 : 컵라면 (골드2)
알고리즘 분류 : 자료 구조, 그리디 알고리즘, 우선순위 큐
풀이 : https://cuckoobird.tistory.com/136
결과 : 맞았습니다 (메모리 76072KB | 시간 1172ms | 코드 길이 1521B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Node implements Comparable<Node> {
		int deadLine;
		int cup;
		
		public Node(int deadLine, int cup) {
			this.deadLine = deadLine;
			this.cup = cup;
		}
		
		@Override
		public int compareTo(Node node) {
			if(this.deadLine < node.deadLine) return -1;
			
			else if(this.deadLine == node.deadLine) {
				if(this.cup > node.cup) return -1;
				else if(this.cup == node.cup) return 0;
				else return 1;
			}
			
			else return 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		
		Node[] arr = new Node[n];
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int deadLine = Integer.parseInt(st.nextToken());
			int cup = Integer.parseInt(st.nextToken());
			
			arr[i] = new Node(deadLine, cup);
		}
		
		Arrays.parallelSort(arr);
		
		for(Node a : arr) {
			if(q.size() < a.deadLine) {
				q.offer(a.cup);
			} else if(q.size() == a.deadLine) {
				int c = q.peek();
				if(c < a.cup) {
					q.poll();
					q.offer(a.cup);
				}
			}
		}
		
		long sum = 0;
		while(!q.isEmpty()) {
			sum += q.poll();
		}
		
		bw.write(sum + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
