#include <stdio.h>
int main()
{
	int dp[11] = { 0 };
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;

	for (int i = 4; i < 11; i++)
	{
		dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
	}

	int N;
	scanf("%d", &N);
	int* t;
	t = (int*)malloc(sizeof(int)* N);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &t[i]);
	}
	for (int i = 0; i < N; i++)
	{
		printf("%d\n", dp[t[i]]);
	}
}