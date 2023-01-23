import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		String input;
		int one_half = 0, one_quarter = 0, three_fourths = 0;
		for (int i = 0 ; i <= N ; i ++) {
			input = scanner.nextLine();
			if (input.equals("1/2")) {
				one_half ++;
			} else if (input.equals("1/4")) {
				one_quarter ++;
			} else if (input.equals("3/4")) {
				three_fourths ++;
			}
		}
		int answer = 0;
		answer += three_fourths;
		one_quarter -= three_fourths;
		answer += one_half / 2;
		one_half %= 2;
		if (one_quarter > 0) {
			if (one_half == 1) {
				one_quarter -= 2;
				answer ++;
			}
			if (one_quarter > 0) {
				one_quarter --;
				answer += one_quarter / 4 + 1;
			}
		} else {
			answer += one_half;
		}
		System.out.println(answer);
	}

}
