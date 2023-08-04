/*
백준 1424번 : 새 앨범 (골드5)
알고리즘 분류 : 수학
풀이 : https://cuckoobird.tistory.com/123
결과 : 틀렸습니다 (코드 길이 1049B)
메모 : 후에 수정
*/

import java.io.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		int l = Integer.parseInt(bf.readLine());
		int c = Integer.parseInt(bf.readLine());
		
		// 시디 한 장에 들어갈 노래의 수
		int c_l = (c + 1) / (l + 1);
		// 시디 한 장에 들어갈 노래의 개수가 13으로 나누어 떨어지면 노래의 개수를 한개 줄임
		if(c_l % 13 == 0) c_l --;
		
		// 시디의 개수
		int cnt = n / c_l;
		// 시디에 넣고 남은 노래의 개수 rest
		int rest = n % c_l;
		// 남으면 시디를 추가함
		if(rest > 0) {
			cnt ++;
			// 만약 남은 노래가 13으로 나누어 떨어지면 하나 더 추가
			if(rest % 13 == 0) cnt ++;
		}
		
		bw.write(cnt + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
}
