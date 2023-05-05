#include <stdio.h>
int main()
{
	int T, N, M;

	scanf("%d", &T);
	long long temp;
	long long* arr = (long long*)malloc(sizeof(long long) * T);
	for (int i = 0; i < T; i++)
	{
		temp = 1;
		scanf("%d %d", &N, &M);
		for (int i = 0; i <N; i++)
		{
			temp = temp * (M - (long long)i) / (i + (long long)1);
		}
		arr[i] = temp;

	}
	for (int i = 0; i < T; i++)
	{
		printf("%lld\n", arr[i]);
	}
}