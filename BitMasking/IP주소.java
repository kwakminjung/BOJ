/*
백준 2064번 : IP 주소 (골드4)
알고리즘 분류 : 구현, 비트마스킹
풀이 : https://cuckoobird.tistory.com/102
결과 : 틀렸습니다 (코드 길이 3402B)
메모 : 
비트마스킹 이해 후에 다시 시도하기
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] max = {0, 0, 0, 0};
		int[] min = {255, 255, 255, 255};
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(bf.readLine(), ".");
			int[] tmp = new int[4];
			boolean flag_max = true;
			boolean flag_min = true;
			for(int j = 0 ; j < 4 ; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
				if(max[j] <= tmp[j] && flag_max) flag_max = true;
				else flag_max = false;
				if(min[j] >= tmp[j] && flag_min) flag_min = true;
				else flag_min = false;
			}
			if(flag_max) max = tmp;
			if(flag_min) min = tmp;
		}
		char[] max_char = new char[32];
		char[] min_char = new char[32];
		for(int i = 0 ; i < 4 ; i++) {
			String maxBinary = String.format("%8s", Integer.toBinaryString(max[i])).replace(' ', '0');
		    String minBinary = String.format("%8s", Integer.toBinaryString(min[i])).replace(' ', '0');
			for(int j = 7 ; j >= 0 ; j--) {
				max_char[j + 8 * i] = maxBinary.charAt(j);
		        min_char[j + 8 * i] = minBinary.charAt(j);
			}
		}
		char[] one = {'0', '0', '0', '0', '0', '0', '0', '0'
        		, '0', '0', '0', '0', '0', '0', '0', '0'
        		, '0', '0', '0', '0', '0', '0', '0', '0'
        		, '0', '0', '0', '0', '0', '0', '0', '1'};
		int[] network_add = Binary_minus(min_char, one);
		for(int i = 0 ; i < 4 ; i++) {
			bw.write(Integer.toString(network_add[i]));
			if(i < 3) bw.write(".");
		}
		bw.write("\n");
		
		int[] sub_arr = Binary_minus(max_char, min_char);
		int sub_result = 0;
		for(int i = 0 ; i < 4 ; i++) {
			sub_result += Math.pow(256, (3 - i)) * sub_arr[i];
		}
		
		int m = 0;
		while(true) {
			if(Math.pow(2, m) < sub_result) m ++; 
			else break;
			
		}
		
		char[] networkmask_bin = new char[32];
		for(int i = 0 ; i < 32 ; i++) {
			if(i < 32 - m) {
				networkmask_bin[i] = '1';
			} else {
				networkmask_bin[i] = '0';
			}
		}
		
		int[] networkmask = new int[4];
		for(int i = 0 ; i < 4 ; i++) {
			int sum = 0;
			for(int j = 7 ; j >= 0 ; j--) {
				if(networkmask_bin[j + 8 * i] == '1') sum += Math.pow(2, 7 - j);
			}
			networkmask[i] = sum;
		}
		for(int i = 0 ; i < 4 ; i++) {
			bw.write(Integer.toString(networkmask[i]));
			if(i < 3) bw.write(".");
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	private static int[] Binary_minus(char[] bin1, char[] bin2) {
        char[] ans = new char[32];
        int r = 0;
        for (int i = 31; i >= 0; i--) {
            int bin1Int = bin1[i] - '0';
            int bin2Int = bin2[i] - '0';
            r += bin1Int - bin2Int;
            if (r < 0) {
            	r += 2;
            	if(r == 0) ans[i] = '0';
            	else ans[i] = '1';
            	r = -1;
            } else {
            	if(r == 0) ans[i] = '0';
            	else ans[i] = '1';
            	r = 0;
            }
        }
        int[] ans_bin = new int[4];
        String str = new String(ans);
        for (int i = 0; i < 4; i++) {
            ans_bin[i] = Integer.parseInt(str.substring(i * 8, (i + 1) * 8), 2);
        }
        return ans_bin;
    }
}
