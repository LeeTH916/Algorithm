#include <iostream>
#include <stack>

using namespace std;

int dp[1001][1001];

stack <char> s;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	char str1[1001], str2[1001];

	cin >> str1 >> str2;

	int i, j;

	for (i = 0; str1[i] != 0; i++)
	{
		for (j = 0; str2[j] != 0; j++)
		{
			if (str1[i] == str2[j])
			{
				dp[i + 1][j + 1] = dp[i][j] + 1;
			}
			else
			{
				dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j]);
			}
		}
	}

	cout << dp[i][j]<<'\n';
	if (dp[i][j] > 0)
	{
		while (i > 0 && j > 0)
		{
			if (dp[i - 1][j] == dp[i][j])
			{
				i = i - 1;
			}
			else if (dp[i][j - 1] == dp[i][j])
			{
				j = j - 1;
			}
			else
			{
				s.push(str1[i-1]);
				i = i - 1;
				j = j - 1;
			}
		}

		while (s.empty() == 0)
		{
			cout << s.top();
			s.pop();
		}
	}

}