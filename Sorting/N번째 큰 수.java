import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		
		int[] A = new int[10];
		int[] ans = new int[num];
		int tmp;
		
		for(int k=0 ;k <num ;k ++) {
			for(int i=0;i<10;i++) {
				A[i] = sc.nextInt();
			}
			
			for(int i=0 ; i<10 ; i++) {
				for(int j=i; j<10 ; j++) {
					if(A[i] < A[j]) {
						tmp = A[i];
						A[i] = A[j];
						A[j] = tmp;
					}
				}
			}
			ans[k] = A[2];
		}
		for(int i=0;i<num;i++) {
			System.out.println(ans[i]);		
		}
	}

}
