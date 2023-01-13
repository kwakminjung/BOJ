#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	unsigned long X, Y, W, S, h1, h2, h3, longSide;

	scanf("%d %d %d %d", &X, &Y, &W, &S);

	h1 = W * (X + Y);

	h2 = 0;
	longSide = X > Y ? X : Y;
	if (X % 2 == 0 && Y % 2 == 0) {
		if (W >= S) {
			h2 += longSide * S;
		}
	}
	else if (X % 2 != 0 && Y % 2 != 0) {
		if (W >= S) {
			h2 += longSide * S;
		}
	}
	else {
		if (W >= S) {
			h2 += (longSide - 1) * S;
			h2 += W;
		}
	}

	h3 = 0;
	if (X <= Y) {
		h3 += X * S;
		h3 += (Y - X) * W;
	}
	else {
		h3 += Y * S;
		h3 += (X - Y) * W;
	}
	unsigned long result;

	if (h2 == 0) {
		result = h1;
	}
	else {
		result = h1 < h2 ? h1 : h2;
	}
	result = result < h3 ? result : h3;

	printf("%ld", result);

	return 0;
}
