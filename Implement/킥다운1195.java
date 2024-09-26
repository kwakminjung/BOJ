import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String key1 = br.readLine();
		String key2 = br.readLine();
		
		int answer = Math.min(solution(key1, key2), solution(key2, key1));
		System.out.println(answer);
	}
	
	public static int solution(String key1, String key2) {
		int answer = key1.length() > key2.length() ? key1.length():key2.length();
		int idx = 0;
		for(int i=0; i<key1.length(); i++) {
			idx = i;
			
			for(int j=0; j<key2.length(); j++) {
				if(key1.charAt(idx) == '2' && key2.charAt(j) == '2') break; 
				else idx++;
				
				if(idx >= key1.length()-1) {
					answer += key2.length() - j + 1;
					return answer;
				}
				if(j == key2.length()-1) {
					return answer;
				}
			}
		}
		return answer;
	}
}
