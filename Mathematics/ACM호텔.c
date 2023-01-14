#include <stdio.h>

int main(void) {
	int T;
	int X, Y;

	scanf("%d", &T);

	for (int k = 0; k < T; k++) {
		int H = 0, W = 0, N = 0;

		scanf("%d %d %d", &H, &W, &N);

		Y = N % H;
		X = N / H + 1;
		if (Y == 0) {
			Y = H;
			X--;
		}

		printf("%d%02d\n", Y, X);
	}
	return 0;
}
