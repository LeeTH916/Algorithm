#include <iostream>
#include <string.h>
#include <algorithm>

using namespace std;

int dp[1000][1000];

char str1[1001];
char str2[1001];
char answer[1001];

int len1 = 0;
int len2 = 0;

int main()
{
	scanf("%s", str1);
	scanf("%s", str2);

	len1 = strlen(str1);
	len2 = strlen(str2);

	for (int i = 1; i <= len1; i++)
	{
		for (int j = 1; j <= len2; j++)
		{
			if (str1[i - 1] == str2[j - 1])
			{
				dp[i][j] = dp[i - 1][j - 1] + 1;
			}
			else
			{
				dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}

	int i, j;
	i = len1;
	j = len2;

	int idx = dp[len1][len2];


	while (1)
	{
		if (i < 0 || j < 0)
		{
			break;
		}
		if (dp[i][j] == dp[i - 1][j])
		{
			i = i - 1;
		}
		else if (dp[i][j] == dp[i][j - 1])
		{
			j = j - 1;
		}
		else
		{
			i = i - 1;
			j = j - 1;
			answer[--idx] = str1[i];
		}
	}

	printf("%d\n", dp[len1][len2]);
	if (dp[len1][len2]!=0)
	{
		printf("%s", answer);
	}
	
}