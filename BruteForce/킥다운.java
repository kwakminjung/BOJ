package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String key1 = br.readLine();
		String key2 = br.readLine();
		
		int answer = Math.min(solution(key1, key2), solution(key2, key1));
		System.out.println(answer);
	}
	
	public static int solution(String key1, String key2) {
		int answer = key1.length() > key2.length() ? key1.length(): key2.length();
		
		int idx = 0;
		int flag = 0;
		for(int i=0; i<key1.length(); i++) {
			idx = i;
			for(int j=0; j<key2.length(); j++) {
				if(key1.charAt(idx) == '2' && key2.charAt(j) == '2') {
					break;
				} else {
					idx ++;
					if(idx >= key1.length()) {
						answer = answer + key2.length() - flag;
						return answer;
					}
				}
				flag = j;
				if(j == key2.length()-1) {
					return answer;
				}
			}
		}
		
		return answer;
	}

}
