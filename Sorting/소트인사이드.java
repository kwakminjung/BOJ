import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		char[] ch = s.toCharArray();
		char tmp;
		
		for(int i=0 ; i<ch.length ; i++) {
			for(int j=i; j<ch.length ; j++) {
				if(ch[i] < ch[j]) {
					tmp = ch[i];
					ch[i] = ch[j];
					ch[j] = tmp;
				}
			}
		}
		for(int i=0;i<ch.length;i++) {
			System.out.print(ch[i]);
		}
	}
}
