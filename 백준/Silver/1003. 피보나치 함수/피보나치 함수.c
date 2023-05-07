#include <stdio.h>

typedef struct node{
	int zero;
	int one;
}NODE;


int main()
{
	NODE cnt[41];
	cnt[0].zero = 1;
	cnt[0].one = 0;

	cnt[1].zero = 0;
	cnt[1].one = 1;

	for (int i = 2; i < 41; i++)
	{
		cnt[i].zero = cnt[i - 2].zero + cnt[i - 1].zero;
		cnt[i].one = cnt[i - 2].one + cnt[i - 1].one;
	}

	int N;
	scanf("%d", &N);
	int* t = (int*)malloc(sizeof(int) * N);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &t[i]);
	}
	for (int i = 0; i < N; i++)
	{
		printf("%d %d\n", cnt[t[i]].zero, cnt[t[i]].one);
	}

}