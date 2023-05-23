import java.util.Scanner;

public class Main {
	static int fib01 = 1;
	static int fib02 = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		fib(num);
		fibonacci(num);
		System.out.println(fib01 + " " + fib02);
	}
	
	static int fib(int n) {
		if(n==1 || n==2) {
			return 1;
		}
		else {
			fib01++;
			return (fib(n-1)+fib(n-2));
		}
	}
	
	static int fibonacci(int n) {
		int[] f = new int[100];
		f[1] = 1;
		f[2] = 1;
		for(int i=3;i<n;i++) {
			fib02++;
			f[i] = f[i-1] + f[i-2];
		}
		return f[n];
	}
}
