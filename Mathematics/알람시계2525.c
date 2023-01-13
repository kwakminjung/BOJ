#include <stdio.h>

int main(void) {
	int A, B, C;
	scanf_s("%d %d", &A, &B);
	scanf_s("%d", &C);

	A += C / 60;
	B += C % 60;

	if (B >= 60) {
		A += 1;
		B -= 60;
	}
	if (A >= 24) {
		A -= 24;
	}

	printf("%d %d", A, B);

	return 0;

}
