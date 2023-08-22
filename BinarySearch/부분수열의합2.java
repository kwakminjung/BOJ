/*
백준 1208번 : 부분수열의 합 2 (골드1)
알고리즘 분류 : 이분 탐색, 중간에서 만나기
풀이 : https://cuckoobird.tistory.com/141
결과 : 맞았습니다 (메모리 104404KB | 시간 	1044ms | 코드 길이 1723B)
메모 : 
두 포인터를 이용한 방식
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static long[] arr;
	private static List<Long> left = new ArrayList<>();
	private static List<Long> right = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		arr = new long[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
        // 입력받은 수열을 반으로 나누고, 반으로 나뉜 수열에서 구할 수 있는 합의 경우를 left, right에 넣음
		// -7, -3, -2, 5, 8 을 입력받았을 경우에 -7, -3 / -2, 5, 8 로 나뉘고
        // left = [-10, -7, -3, 0] / right = [-2, 0, 3, 5, 6, 8, 13] 으로 들어가게 됨
        getSubSequence(0, n / 2, 0, left);
		getSubSequence(n / 2, n, 0, right);
		
		Collections.sort(left);
		Collections.sort(right);
		
        // left와 right를 더함
		long cnt = 0;
		int pl = 0, pr = right.size() - 1;
		
		while(pl < left.size() && pr >= 0) {
			long sum = left.get(pl) + right.get(pr);
			
            // 합이 s가 나오는 경우에 배열에 같은 수가 있는지 확인하여 그 개수를 곱하여 cnt에 더함
            // 만약 [2, 2, 3, 4] 와 [1, 4, 4, 4] 가 있을 경우에, 2는 2개, 4는 3개 이므로 2 * 3을 cnt에 더해줌 
			if(sum == s) {
				long a = left.get(pl);
				long cnt1 = 0;
				while(pl < left.size() && left.get(pl) == a) {
					pl ++;
					cnt1 ++;
				}
				
				long b = right.get(pr);
				long cnt2 = 0;
				while(pr >= 0 && right.get(pr) == b) {
					pr --;
					cnt2 ++;
				}
				
				cnt += cnt1 * cnt2;
			}
			
            // 더한 값이 s보다 작으면 왼쪽 배열을 움직임
			else if(sum < s) pl ++;
            // 더한 값이 s보다 크면 오른쪽 배열을 움직임
			else pr --;
		}
        
        // s == 0 인 경우에는 두 집합의 0 이 더해지는 경우가 포함되기 때문에 1을 빼줌
		if(s == 0) cnt --;
		
		bw.write(cnt + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	public static void getSubSequence(int idx, int end, long sum, List<Long> list) {
		if(idx == end) {
			list.add(sum);
			return;
		}
		getSubSequence(idx + 1, end, sum + arr[idx], list);
		getSubSequence(idx + 1, end, sum , list);
	}
}
