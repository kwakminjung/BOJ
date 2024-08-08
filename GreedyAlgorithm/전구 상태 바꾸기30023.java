/*
백준 30023번 : 전구 상태 바꾸기 (골드5)
알고리즘 분류 : 구현, 그리디 알고리즘
풀이 : https://cuckoobird.tistory.com/196
결과 : 맞았습니다 (메모리 16572KB | 시간 156ms | 코드 길이 1529B)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	final static int MAX = 900_000;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		char[] lights = br.readLine().toCharArray();
		
		int firstLight = lightsOn(n, lights);
		change(lights, 1);
		int secondLight = lightsOn(n, lights) + 1;
		change(lights, 1);
		int thirdLigth = lightsOn(n, lights) + 2;
		int minLights = Math.min(firstLight, Math.min(secondLight, thirdLigth));
		int ans = (minLights == MAX) ? -1:minLights;
		
		System.out.println(ans);
	}
    
    public static int lightsOn(int n, char[] lights) {
    	char[] lightsCopy = Arrays.copyOf(lights, n);
    	int cnt = 0;
    	
    	for(int i=2; i<n-1; i++) {
    		while(lightsCopy[0] != lightsCopy[i-1]) {
    			change(lightsCopy, i);
    			cnt++;
    		}
    	}
    	
    	for(int i=1; i<n; i++) {
    		if(lightsCopy[0] != lightsCopy[i]) {
    			cnt = MAX;
    			break;
    		}
    	}
    	
    	return cnt;
    }
    
    public static void change(char[] lightsCopy, int idx) {
    	for(int i=idx-1; i<=idx+1; i++) {
    		switch(lightsCopy[i]) {
    		case 'R':
    			lightsCopy[i] = 'G';
    			break;
    		case 'G':
    			lightsCopy[i] = 'B';
    			break;
    		case 'B':
    			lightsCopy[i] = 'R';
    			break;
    		}
    	}
    }
}
