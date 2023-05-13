#include <iostream>
#include <algorithm>
#include <string.h>

using namespace std;

int dp[1000][1000];

char str1[1001] ;
char str2[1001] ;

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
			if (str1[i-1] == str2[j-1])
			{
				dp[i][j] = dp[i - 1][j - 1] + 1;
			}
			else
			{
				dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}

	printf("%d", dp[len1][len2]);
}