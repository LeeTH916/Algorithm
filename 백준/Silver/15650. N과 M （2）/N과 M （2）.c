#include <stdio.h>

int N, M;

int * arr;
int * ReadOnlyarr;

void printSolution()
{
	for (int i = 0; i < M; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}

int isOK(int _c, int v)
{
	for (int i = 0; i < M; i++)
	{
		if (arr[i] == v||arr[i]>v)
		{
			return 0;
		}
	}
	return 1;
}

void solve(int _c)
{
	int i;
	for (i = 1; i <= N; i++)
	{
		memcpy(&arr[_c], &ReadOnlyarr[_c], sizeof(int)*(M - _c));
		if (isOK(_c, i) == 1)
		{
			arr[_c] = i;
			if (_c == M - 1)
			{
				printSolution();
			}
			else
			{
				solve(_c + 1);
			}
		}
	}
}


int main()
{
	scanf("%d %d", &N, &M);
	arr = (int *)malloc(sizeof(int)*M);
	ReadOnlyarr = (int *)malloc(sizeof(int)*M);
	memcpy(arr, ReadOnlyarr, sizeof(int)*M);
	solve(0);
}
